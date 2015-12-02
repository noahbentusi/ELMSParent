package ui.tools;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import org.dom4j.Element;

import ui.config.ButtonOrLabelPicture;
import ui.config.GraphicsUtils;
import util.MyDate;

import com.eltima.components.ui.DatePicker;

/**
 * 日历选择器实现类 包含三个部件：显示日历信息的textfield、按钮button
 * 
 * @author czq
 *
 */
@SuppressWarnings("serial")
public class MyDatePicker extends MyLabel {
	//两个获取日期的方法
	@SuppressWarnings("deprecation")
	public  MyDate getMyDate(){
		
		SimpleDateFormat format = new SimpleDateFormat(DefaultFormat);
			Date date;
			try {
				date = format.parse(dateField.getText());
				return new MyDate(date.getYear(), date.getMonth(), date.getDay());
			} catch (ParseException e) {
				return new MyDate(2015, 3, 3);
			}
			
		
	}
	
	public String getDateString() {
		return dateField.getText();
	}
	

	private JFormattedTextField dateField;
	/**
	 * 
	 */
	private JButton button;
	/**
	 * 日历选择器
	 */
	private DatePicker datePicker;

	private static String DefaultFormat = "yyyy-MM-dd";
	private Date date = new Date();
	private Font font = new Font("Times New Roman", Font.BOLD, 25);

	/**
	 * 当label用,需要传入的参数包括三个组件的参数  适合的参数：高50，textfield宽100，按钮宽50
	 * @param config
	 */
	public MyDatePicker(Element config) {
		super(config);

		datePicker = new DatePicker(date, DefaultFormat, null, null);// 自定义参数值

		button = datePicker.getInnerButton();
		dateField = datePicker.getInnerTextField();
		dateField.setFont(font);
		dateField.setEditable(false);
		
		button.addMouseListener(new MyDateButtonListener(button));
		
		try {
			datePicker.setBounds(Integer.parseInt(config.attributeValue("x")),
					Integer.parseInt(config.attributeValue("y")),
					Integer.parseInt(config.attributeValue("width")),
					Integer.parseInt(config.attributeValue("height")));
			dateField.setBounds(Integer.parseInt(config.attributeValue("fieldx")),
					Integer.parseInt(config.attributeValue("fieldy")),
					Integer.parseInt(config.attributeValue("fieldwidth")),
					Integer.parseInt(config.attributeValue("fieldheight")));
			button.setBounds(Integer.parseInt(config.attributeValue("buttonx")),
					Integer.parseInt(config.attributeValue("buttony")),
					Integer.parseInt(config.attributeValue("buttonwidth")),
					Integer.parseInt(config.attributeValue("buttonheight")));
		} catch (Exception e) {
			
		}
		

		this.add(datePicker);
	}
	/**
	 * 是否带有时钟面板  此时具体到秒
	 * @param config
	 * @param withClock
	 */
	public MyDatePicker(Element config , boolean withClock) {
		super(config);
		DefaultFormat = "yyyy-MM-dd HH:mm:ss";
		datePicker = new DatePicker(date, DefaultFormat, null, null);// 自定义参数值
		datePicker.setTimePanleVisible(withClock);
		
		button = datePicker.getInnerButton();
		dateField = datePicker.getInnerTextField();
		dateField.setFont(font);
		dateField.setEditable(false);
		
		button.addMouseListener(new MyDateButtonListener(button));
		
		try {
			datePicker.setBounds(Integer.parseInt(config.attributeValue("x")),
					Integer.parseInt(config.attributeValue("y")),
					Integer.parseInt(config.attributeValue("width")),
					Integer.parseInt(config.attributeValue("height")));
			dateField.setBounds(Integer.parseInt(config.attributeValue("fieldx")),
					Integer.parseInt(config.attributeValue("fieldy")),
					Integer.parseInt(config.attributeValue("fieldwidth")),
					Integer.parseInt(config.attributeValue("fieldheight")));
			button.setBounds(Integer.parseInt(config.attributeValue("buttonx")),
					Integer.parseInt(config.attributeValue("buttony")),
					Integer.parseInt(config.attributeValue("buttonwidth")),
					Integer.parseInt(config.attributeValue("buttonheight")));
		} catch (Exception e) {
			
		}
		

		this.add(datePicker);
	}
	
	
	
	
	
	
	class MyDateButtonListener extends MouseAdapter {
		private JButton button;

		private Icon normal;
		private Icon enter;
		private Icon clicked;

		public MyDateButtonListener(JButton button) {
			this.button = button;
			ButtonOrLabelPicture pics = GraphicsUtils
					.getButtonLabelPic("calendar");
			normal = pics.getNormal();
			enter = pics.getEnter();
			clicked = pics.getClicked();
			button.setIcon(normal);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			button.setIcon(clicked);

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			button.setIcon(enter);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			button.setIcon(normal);
		}

	}

}
