package org.translate.core.service;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.translate.min.message.response.TextMessage;
import org.translate.min.util.MessageUtil;


public class CoreService
{
	/**
	 * ����΢�ŷ���������
	 */
	public static String processReqquest(HttpServletRequest request)
	{
		String responseMessage = null;

		//xml�������
		try
		{
			//Ĭ�Ϸ��ص��ı���Ϣ����
			String responseContent = "�������쳣�����Ժ���";
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			//���ͷ��˺ţ�openId��
			String fromUserName = requestMap.get("FromUserName");
			//�����˺�
			String toUserName = requestMap.get("ToUserName");
			//��Ϣ����
			String messageType = requestMap.get("MsgType");
			
			//�ָ��ı���Ϣ
			TextMessage textMessage = new TextMessage();  
            textMessage.setToUserName(fromUserName);  
            textMessage.setFromUserName(toUserName);  
            textMessage.setCreatTime(new Date().getTime());  
            textMessage.setMessageType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);  
            textMessage.setFuncFlag(0); 
			
            // �ı���Ϣ  
            if (messageType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {  
                responseContent = "�����͵����ı���Ϣ��";  
            }  
            // ͼƬ��Ϣ  
            else if (messageType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {  
                responseContent = "�����͵���ͼƬ��Ϣ��";  
            }  
            // ����λ����Ϣ  
            else if (messageType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {  
                responseContent = "�����͵��ǵ���λ����Ϣ��";  
            }  
            // ������Ϣ  
            else if (messageType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {  
                responseContent = "�����͵���������Ϣ��";  
            }  
            // ��Ƶ��Ϣ  
            else if (messageType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {  
                responseContent = "�����͵�����Ƶ��Ϣ��";  
            }  
            // ͼ����Ϣ
            else if (messageType.equals(MessageUtil.RESP_MESSAGE_TYPE_NEWS)) {  
            	responseContent = "�����͵���ͼ����Ϣ��";  
            }  
            // �¼�����  
            else if (messageType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {  
                // �¼�����  
                String eventType = requestMap.get("Event");  
                // ����  
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {  
                    responseContent = "лл���Ĺ�ע��";  
                }  
                // ȡ������  
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {  
                    // TODO ȡ�����ĺ��û����ղ������ںŷ��͵���Ϣ����˲���Ҫ�ظ���Ϣ  
                }  
                // �Զ���˵�����¼�  
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {  
                	String eventKey = requestMap.get("EventKey");  
                	  
                    if (eventKey.equals("11")) {  
                        responseContent = "����Ԥ���˵�������";  
                    } else if (eventKey.equals("12")) {  
                        responseContent = "������ѯ�˵�������";  
                    } else if (eventKey.equals("13")) {  
                        responseContent = "�ܱ������˵�������";  
                    } else if (eventKey.equals("14")) {  
                        responseContent = "��ʷ�ϵĽ���˵�������";  
                    } else if (eventKey.equals("21")) {  
                        responseContent = "�����㲥�˵�������";  
                    } else if (eventKey.equals("22")) {  
                        responseContent = "������Ϸ�˵�������";  
                    } else if (eventKey.equals("23")) {  
                        responseContent = "��Ů��̨�˵�������";  
                    } else if (eventKey.equals("24")) {  
                        responseContent = "����ʶ��˵�������";  
                    } else if (eventKey.equals("25")) {  
                        responseContent = "������ྲ˵�������";  
                    } else if (eventKey.equals("31")) {  
                        responseContent = "Q��Ȧ�˵�������";  
                    } else if (eventKey.equals("32")) {  
                        responseContent = "��Ӱ���а�˵�������";  
                    } else if (eventKey.equals("33")) {  
                        responseContent = "��ĬЦ���˵�������";  
                    }    
                }  
            }  
            textMessage.setContent(responseContent);  
            responseMessage = MessageUtil.textMessageToXml(textMessage);  
		} catch (Exception e)
		{
			e.printStackTrace();
		} 
		return responseMessage;
	}
	
}
