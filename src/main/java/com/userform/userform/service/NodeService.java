package com.userform.userform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userform.userform.model.Node;
import com.userform.userform.repository.NodeRepository;

@Service
public class NodeService {

	@Autowired
	private NodeRepository nodeRepository;

	public Node saveNode(Node node) {
		Optional<Node> existingUser = nodeRepository.findByNodeId(node.getNodeId());

		if (existingUser.isPresent()) {
			return existingUser.get();
		} else {
			return nodeRepository.save(node);
		}
	}

	public List<Node> getAllUsers() {
		return nodeRepository.findAll();
	}

	public Optional<Node> getNodeById(String nodeId) {
		return nodeRepository.findByNodeId(nodeId);
	}

	public void deleteUser(String nodeId) {
		Long id = Long.parseLong(nodeId);
		nodeRepository.deleteById(id);
	}
}
