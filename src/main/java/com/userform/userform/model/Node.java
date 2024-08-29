package com.userform.userform.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "nodes")
public class Node {

	private static final String NO_SPECIAL_CHARS_REGEX = "^[^!@#$%^&*()]+$";
	private static final String SPECIAL_CHARS_MESSAGE = "should not contain special characters";

	public Node() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Node ID is mandatory")
	@Pattern(regexp = NO_SPECIAL_CHARS_REGEX, message = "Node ID " + SPECIAL_CHARS_MESSAGE)
	private String nodeId;

	@NotBlank(message = "Node name is mandatory")
	@Pattern(regexp = NO_SPECIAL_CHARS_REGEX, message = "Node name " + SPECIAL_CHARS_MESSAGE)
	private String nodeName;

	@NotBlank(message = "description is mandatory")
	@Pattern(regexp = NO_SPECIAL_CHARS_REGEX, message = "Node name " + SPECIAL_CHARS_MESSAGE)
	private String description;

	@NotBlank(message = "memo is mandatory")
	@Pattern(regexp = NO_SPECIAL_CHARS_REGEX, message = "Node name " + SPECIAL_CHARS_MESSAGE)
	private String memo;

	@Pattern(regexp = NO_SPECIAL_CHARS_REGEX, message = "Node name " + SPECIAL_CHARS_MESSAGE)
	@NotBlank(message = "Node type is mandatory")
	private String nodeType;

	@Pattern(regexp = NO_SPECIAL_CHARS_REGEX, message = "Node name " + SPECIAL_CHARS_MESSAGE)
	@NotBlank(message = "parentNodeGroupName type is mandatory")
	private String parentNodeGroupName;

	@NotNull(message = "Parent node group ID is mandatory")
	@Pattern(regexp = NO_SPECIAL_CHARS_REGEX, message = "Node name " + SPECIAL_CHARS_MESSAGE)
	private String parentNodeGroupId;

	@NotNull(message = "Parent node is mandatory")
	@Pattern(regexp = NO_SPECIAL_CHARS_REGEX, message = "Node name " + SPECIAL_CHARS_MESSAGE)
	private String parentNode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public String getParentNodeGroupName() {
		return parentNodeGroupName;
	}

	public void setParentNodeGroupName(String parentNodeGroupName) {
		this.parentNodeGroupName = parentNodeGroupName;
	}

	public String getParentNodeGroupId() {
		return parentNodeGroupId;
	}

	public void setParentNodeGroupId(String parentNodeGroupId) {
		this.parentNodeGroupId = parentNodeGroupId;
	}

	public String getParentNode() {
		return parentNode;
	}

	public void setParentNode(String parentNode) {
		this.parentNode = parentNode;
	}

	@Override
	public String toString() {
		return "Node [id=" + id + ", nodeId=" + nodeId + ", nodeName=" + nodeName + ", description=" + description
				+ ", memo=" + memo + ", nodeType=" + nodeType + ", parentNodeGroupName=" + parentNodeGroupName
				+ ", parentNodeGroupId=" + parentNodeGroupId + ", parentNode=" + parentNode + "]";
	}

}
