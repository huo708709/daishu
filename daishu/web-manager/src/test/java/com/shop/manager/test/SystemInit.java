package com.shop.manager.test;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SystemInit {

	public static void main(String[] args) throws Exception {
		File f = new File("E:/Workspaces/rizu/shop-manager/src/test/resources/init.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(f);
		NodeList menus = doc.getChildNodes();
		Node node = menus.item(0);
		NodeList children = node.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			if (StringUtils.equals(child.getNodeName(), "menus")) {
				buildMenu(child);
			} else if (StringUtils.equals(child.getNodeName(), "users")) {
				buildUser(child);
			} else if (StringUtils.equals(child.getNodeName(), "roles")) {
				buildRole(child);
			} else if (StringUtils.equals(child.getNodeName(), "userroles")) {
				buildUserRoles(child);
			}
		}
	}
	
	public static void buildUser(Node userRoot) {
		NodeList userNodes = userRoot.getChildNodes();
		for (int i = 0; i < userNodes.getLength(); i++) {
			Node userNode = userNodes.item(i);
			if (StringUtils.equals(userNode.getNodeName(), "user")) {
				NamedNodeMap userNodeMap = userNode.getAttributes();
				String username = userNodeMap.getNamedItem("username").getNodeValue();
				String password = userNodeMap.getNamedItem("password").getNodeValue();
				
				System.out.println(username);
				System.out.println(password);
			}
		}
	}
	
	public static void buildRole(Node roleRoot) {
		NodeList roleNodes = roleRoot.getChildNodes();
		for (int i = 0; i < roleNodes.getLength(); i++) {
			Node roleNode = roleNodes.item(i);
			if (StringUtils.equals(roleNode.getNodeName(), "role")) {
				NamedNodeMap roleNodeMap = roleNode.getAttributes();
				String name = roleNodeMap.getNamedItem("name").getNodeValue();
				String description = roleNodeMap.getNamedItem("description").getNodeValue();
				
				System.out.println(name);
				System.out.println(description);
			}
		}
	}
	
	public static void buildUserRoles(Node userroleRoot) {
		NodeList userroleNodes = userroleRoot.getChildNodes();
		for (int i = 0; i < userroleNodes.getLength(); i++) {
			Node userroleNode = userroleNodes.item(i);
			if (StringUtils.equals(userroleNode.getNodeName(), "userrole")) {
				NamedNodeMap userroleNodeMap = userroleNode.getAttributes();
				String username = userroleNodeMap.getNamedItem("username").getNodeValue();
				String rolename = userroleNodeMap.getNamedItem("rolename").getNodeValue();
				
				System.out.println(username);
				System.out.println(rolename);
			}
		}
	}
	
	public static void buildMenu(Node menuRoot) {
		NodeList menuNodes = menuRoot.getChildNodes();
		for (int i = 0; i < menuNodes.getLength(); i++) {
			Node menuNode =  menuNodes.item(i);
			if (StringUtils.equals(menuNode.getNodeName(), "menu")) {
				NamedNodeMap nodeMap = menuNode.getAttributes();
				String name = nodeMap.getNamedItem("name").getNodeValue();
				String code = nodeMap.getNamedItem("code").getNodeValue();
				String icon = nodeMap.getNamedItem("icon").getNodeValue();
				
				System.out.println(name);
				System.out.println(code);
				System.out.println(icon);
				
				NodeList nodeList = menuNode.getChildNodes();
				for (int j = 0; j < nodeList.getLength(); j++) {
					Node node = nodeList.item(j);
					if (StringUtils.equals(node.getNodeName(), "functions")) {
						NodeList functions = node.getChildNodes();
						for (int k = 0; k < functions.getLength(); k++) {
							Node function = functions.item(k);
							if (StringUtils.equals(function.getNodeName(), "function")) {
								NamedNodeMap functionNodeMap = function.getAttributes();
								System.out.println(functionNodeMap.getNamedItem("name").getNodeValue());
								System.out.println(functionNodeMap.getNamedItem("code").getNodeValue());
							}
						}
					} else if (StringUtils.equals(node.getNodeName(), "children")) {
						buildMenu(node);
					}
				}
			}
		}
	}
}
