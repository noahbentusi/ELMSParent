package ui.tools;

import java.awt.Color;
import javax.swing.JTextField;

import org.dom4j.Element;

import ui.config.GraphicsUtils;

/**
 * 
 * @author czq
 * @version 2015年11月16日 下午7:37:20
 */
@SuppressWarnings("serial")
public class MyTextField extends JTextField {

	public MyTextField() {
		this.setOpaque(true);
		this.setForeground(Color.BLACK);
		
		this.setVisible(true);
		
	}

	public MyTextField(int x, int y, int width, int height) {
		this.setBounds(x, y, width, height);
		this.setForeground(Color.BLACK);
		this.setVisible(true);
	}
	
	public MyTextField(Element config){
		this.setBounds(Integer.parseInt(config.attributeValue("x")) , Integer.parseInt(config.attributeValue("y")) , Integer.parseInt(config.attributeValue("width")) , Integer.parseInt(config.attributeValue("height")));
		if(config.attributeValue("text")!=null){
			this.setText(config.attributeValue("text"));
		}
		this.setFont(GraphicsUtils.getFont(null));
		this.setVisible(true);
		
	}
	
}
