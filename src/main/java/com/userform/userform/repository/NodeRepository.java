package com.userform.userform.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userform.userform.model.Node;

@Repository
public interface NodeRepository extends JpaRepository<Node, Long> {
	Optional<Node> findByNodeId(String nodeId);
}


