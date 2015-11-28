package ui.tools;

import javax.swing.Icon;
import javax.swing.JLabel;

import org.dom4j.Element;

import ui.config.GraphicsUtils;
import ui.util.ButtonState;

/**
 * 带有图片的button按钮
 * 
 * @author czq
 * @version 2015年11月26日 下午7:19:05
 */
@SuppressWarnings("serial")
public class MyPictureButton extends JLabel {

	// 一个按钮分：普通、进入、点击 三种不同的图片状态

	private Icon normal;
	private Icon entered;
	private Icon clicked;

	public MyPictureButton(Element e) {

		normal = GraphicsUtils.getIcon(e.attributeValue("normal"));
		entered = GraphicsUtils.getIcon(e.attributeValue("enter"));
		clicked = GraphicsUtils.getIcon(e.attributeValue("clicked"));

		this.setIcon(normal);
		this.setBounds(Integer.parseInt(e.attributeValue("x")),
				Integer.parseInt(e.attributeValue("y")),
				Integer.parseInt(e.attributeValue("width")),
				Integer.parseInt(e.attributeValue("height")));

		this.setFont(GraphicsUtils.getFont(e.addAttribute("fontname", "size")));

		this.setText(e.attributeValue("text"));
		this.repaint();
		this.setVisible(true);
	}

	public void setMyIcon(ButtonState state) {
		switch (state) {
		case NORMAL:
			this.setIcon(normal);
			break;
		case MOUSE_ENTERED:
			this.setIcon(entered);
			break;
		case MOUSE_CLICKED:
			this.setIcon(clicked);
			break;
		default:
			break;
		}

	}
}