package com.userform.userform.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.userform.userform.model.Node;
import com.userform.userform.service.NodeService;
import com.userform.userform.service.NodeServiceCsv;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class NodeController {

    @Autowired
    private NodeService nodeService;
    
    @Autowired
    private NodeServiceCsv nodeServiceCsv;
    

    @PostMapping(path = "/addnode")
    public ResponseEntity<Node> createUser(@RequestBody @Valid Node node) {
    	Node savedUser = nodeService.saveNode(node);
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    @GetMapping(path = "/allnodes")
    public ResponseEntity<List<Node>> getAllUsers() {
        List<Node> users = nodeService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    
    @GetMapping(path = "/test")
    public String hello() {
        return "Hello";
    }
    
    @PostMapping("/import")
    public ResponseEntity<String> importNodes(@RequestParam("file") MultipartFile file) {
        try {
        	nodeServiceCsv.importCSV(file);
            return ResponseEntity.ok("File uploaded and data imported successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to import data: " + e.getMessage());
        }
    }
    
    @PutMapping(path = "/update/{nodeId}")
    public ResponseEntity<Node> updateNode(@PathVariable String nodeId, @RequestBody @Valid Node nodeDetails) {
        Optional<Node> existingNodeOpt = nodeService.getNodeById(nodeId);
        if (existingNodeOpt.isPresent()) {
            Node existingNode = existingNodeOpt.get();
            existingNode.setNodeName(nodeDetails.getNodeName());
            existingNode.setDescription(nodeDetails.getDescription());
            existingNode.setMemo(nodeDetails.getMemo());
            existingNode.setNodeType(nodeDetails.getNodeType());
            existingNode.setParentNodeGroupName(nodeDetails.getParentNodeGroupName());
            existingNode.setParentNodeGroupId(nodeDetails.getParentNodeGroupId());
            existingNode.setParentNode(nodeDetails.getParentNode());
            Node updatedNode = nodeService.saveNode(existingNode);
            return new ResponseEntity<>(updatedNode, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/delete/{nodeId}")
    public ResponseEntity<String> deleteNode(@PathVariable String nodeId) {
        Optional<Node> node = nodeService.getNodeById(nodeId);
        if (node.isPresent()) {
            nodeService.deleteUser(nodeId);
            return new ResponseEntity<>("Node deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Node not found", HttpStatus.NOT_FOUND);
        }
    }
}

