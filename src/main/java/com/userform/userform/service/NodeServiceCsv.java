package com.userform.userform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.userform.userform.model.Node;
import com.userform.userform.repository.NodeRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Service
public class NodeServiceCsv {

    @Autowired
    private NodeRepository nodeRepository;

    public void importCSV(MultipartFile file) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            List<Node> nodes = reader.lines()
                .skip(1) // skip header line
                .map(line -> {
                    String[] fields = line.split(",");
                    Node node = new Node();
                    node.setNodeId(fields[0]);
                    node.setNodeName(fields[1]);
                    node.setDescription(fields[2]);
                    node.setMemo(fields[3]);
                    node.setNodeType(fields[4]);
                    node.setParentNodeGroupName(fields[5]);
                    node.setParentNodeGroupId(fields[6]);
                    node.setParentNode(fields[7]);
                    return node;
                })
                .collect(Collectors.toList());

            for (Node node : nodes) {
                Optional<Node> existingNode = nodeRepository.findByNodeId(node.getNodeId());
                if (existingNode.isPresent()) {
                    System.out.println("Node already exists: " + node.getNodeId());
                } else {
                	nodeRepository.save(node);
                }
            }
        }
    }
}
