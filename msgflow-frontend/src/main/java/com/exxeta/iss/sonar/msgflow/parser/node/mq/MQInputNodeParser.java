package com.exxeta.iss.sonar.msgflow.parser.node.mq;

import javax.xml.xpath.XPathExpressionException;

import org.sonar.api.utils.log.Logger;
import org.sonar.api.utils.log.Loggers;
import org.w3c.dom.Element;

import com.exxeta.iss.sonar.msgflow.parser.node.NodeParser;
import com.exxeta.iss.sonar.msgflow.tree.impl.node.mq.MQInputNodeImpl;

public class MQInputNodeParser extends NodeParser<MQInputNodeImpl> {

	private static final String NODE_TYPE = "ComIbmMQInput.msgnode";
	private static final Logger LOGGER = Loggers.get(MQInputNodeParser.class);

	@Override
	public String getNodeType() {
		return NODE_TYPE;
	}

	@Override
	public MQInputNodeImpl parseMessageFlowNode(final Element nodeElement) {

		try {
			return new MQInputNodeImpl(nodeElement, getId(nodeElement), getName(nodeElement), getLocationX(nodeElement),
					getLocationY(nodeElement), nodeElement.getAttribute("queueName"));
		} catch (final XPathExpressionException e) {
			LOGGER.error("cannot parse AggregateControlNode", e);
			return null;
		}

	}

}
