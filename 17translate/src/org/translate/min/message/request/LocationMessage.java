package org.translate.min.message.request;

public class LocationMessage extends BaseMessage
{
	//����λ��ά��
	private String location_x;
	//����λ�þ���
	private String location_y;
	//��ͼ���Ŵ�С
	private String scale;
	//����λ����Ϣ
	private String label;
	public String getLocation_x()
	{
		return location_x;
	}
	public void setLocation_x(String location_x)
	{
		this.location_x = location_x;
	}
	public String getLocation_y()
	{
		return location_y;
	}
	public void setLocation_y(String location_y)
	{
		this.location_y = location_y;
	}
	public String getScale()
	{
		return scale;
	}
	public void setScale(String scale)
	{
		this.scale = scale;
	}
	public String getLabel()
	{
		return label;
	}
	public void setLabel(String label)
	{
		this.label = label;
	}

	
	
}
