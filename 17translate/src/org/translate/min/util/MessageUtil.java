package org.translate.min.util;

import java.io.InputStream;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;


import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.translate.min.message.response.Article;
import org.translate.min.message.response.MusicMessage;
import org.translate.min.message.response.NewsMessage;
import org.translate.min.message.response.TextMessage;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class MessageUtil
{
	/**
	 * ������Ϣ���ͣ��ı�
	 */
	 public static final String RESP_MESSAGE_TYPE_TEXT = "text"; 
	/** 
     * ������Ϣ���ͣ����� 
     */  
    public static final String RESP_MESSAGE_TYPE_MUSIC = "music";  
  
    /** 
     * ������Ϣ���ͣ�ͼ�� 
     */  
    public static final String RESP_MESSAGE_TYPE_NEWS = "news";  
  
    /** 
     * ������Ϣ���ͣ��ı� 
     */  
    public static final String REQ_MESSAGE_TYPE_TEXT = "text";  
  
    /** 
     * ������Ϣ���ͣ�ͼƬ 
     */  
    public static final String REQ_MESSAGE_TYPE_IMAGE = "image";  
  
    /** 
     * ������Ϣ���ͣ����� 
     */  
    public static final String REQ_MESSAGE_TYPE_LINK = "link";  
  
    /** 
     * ������Ϣ���ͣ�����λ�� 
     */  
    public static final String REQ_MESSAGE_TYPE_LOCATION = "location";  
  
    /** 
     * ������Ϣ���ͣ���Ƶ 
     */  
    public static final String REQ_MESSAGE_TYPE_VOICE = "voice";  
  
    /** 
     * ������Ϣ���ͣ����� 
     */  
    public static final String REQ_MESSAGE_TYPE_EVENT = "event";  
  
    /** 
     * �¼����ͣ�subscribe(����) 
     */  
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";  
  
    /** 
     * �¼����ͣ�unsubscribe(ȡ������) 
     */  
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";  
  
    /** 
     * �¼����ͣ�CLICK(�Զ���˵�����¼�) 
     */  
    public static final String EVENT_TYPE_CLICK = "CLICK";  
    
    /**
     * ����΢�ŷ���������
     * @throws Exception 
     */
    public static Map<String, String> parseXml(HttpServletRequest request) throws Exception
    {
    	//����������洢��HashMap��
    	Map<String, String> map = new HashMap<String, String>();
    	
    	//��request��ȡ��������
    	InputStream inputStream = request.getInputStream();
    	//��ȡ������
    	SAXReader reader = new SAXReader();
    	Document document = reader.read(inputStream);  
    	//�õ�xml��Ԫ��
    	Element root = document.getRootElement();
    	//�õ���Ԫ�ص������ӽڵ�
    	List<Element> elementList = root.elements();
    	//���������ӽڵ�
    	for(Element e : elementList)
    	{
    		map.put(e.getName(), e.getText());
    	}
    	//�ͷ���Դ
    	inputStream.close();
    	inputStream = null;
    	
		return map;
    }
    /**
     * �ı�����ת��Ϊxml
     */
    public static String textMessageToXml(TextMessage textMessage)
    {
    	 xstream.alias("xml", textMessage.getClass());  
    	 return xstream.toXML(textMessage);
    }
    /**
     * ������Ϣ����ת��Ϊxml
     */
    public static String musicMessageToXml(MusicMessage musicMessage)
    {
    	xstream.alias("xml", musicMessage.getClass());
    	return xstream.toXML(musicMessage);
    }
    /**
     * ͼ����Ϣ����ת��Ϊxml
     */
    public static String newsMessageToXml(NewsMessage newsMessage)
    {
    	xstream.alias("xml", newsMessage.getClass());
    	xstream.alias("item", new Article().getClass());
    	return xstream.toXML(newsMessage);
    }
    
    /** 
     * ��չxstream��ʹ��֧��CDATA�� 
     */  
    private static XStream xstream = new XStream(new XppDriver()
    {  
        public HierarchicalStreamWriter createWriter(Writer out)
        {  
            return new PrettyPrintWriter(out) 
            {  
                // ������xml�ڵ��ת��������CDATA���  
                boolean cdata = true;  
  
                @SuppressWarnings("unchecked")  
                public void startNode(String name, Class clazz)
                {  
                    super.startNode(name, clazz);  
                }  
  
                protected void writeText(QuickWriter writer, String text)
                {  
                    if (cdata) 
                    {  
                        writer.write("<![CDATA[");  
                        writer.write(text);  
                        writer.write("]]>");  
                    } else 
                    {  
                        writer.write(text);  
                    }  
                }  
            };  
        }  
    }); 
    
    /**
     * �ж��Ƿ���QQ����
     */
    public static boolean isQqFace(String content)
    {
    	boolean result = false;
    	//�ж�QQ�����������ʽ
    	String qqFaceRegex = "/::\\)|/::~|/::B|/::\\||/:8-\\)|/::<|/::$|/::X|/::Z|/::'\\(|/::-\\||" +
    			"/::@|/::P|/::D|/::O|/::\\(|/::\\+|/:--b|/::Q|/::T|/:,@P|/:,@-D|/::d|/:,@o|/::g|/:\\|" +
    			"-\\)|/::!|/::L|/::>|/::,@|/:,@f|/::-S|/:\\?|/:,@x|/:,@@|/::8|/:,@!|/:!!!|/:xx|/:bye|/" +
    			":wipe|/:dig|/:handclap|/:&-\\(|/:B-\\)|/:<@|/:@>|/::-O|/:>-\\||/:P-\\(|/::'\\||/:X-\\)" +
    			"|/::\\*|/:@x|/:8\\*|/:pd|/:<W>|/:beer|/:basketb|/:oo|/:coffee|/:eat|/:pig|/:rose|/:fade|" +
    			"/:showlove|/:heart|/:break|/:cake|/:li|/:bome|/:kn|/:footb|/:ladybug|/:shit|/:moon|/:sun|" +
    			"/:gift|/:hug|/:strong|/:weak|/:share|/:v|/:@\\)|/:jj|/:@@|/:bad|/:lvu|/:no|/:ok|/:love|/:<L>|" +
    			"/:jump|/:shake|/:<O>|/:circle|/:kotow|/:turn|/:skip|/:oY|/:#-0|/:hiphot|/:kiss|/:<&|/:&>"; 
    	 Pattern p = Pattern.compile(qqFaceRegex);  
    	    Matcher m = p.matcher(content);  
    	    if (m.matches()) {  
    	        result = true;  
    	    }  
    	    return result;  
    }
    /**
     *  ��΢����Ϣ�е�CreateTimeת���ɱ�׼��ʽ��ʱ�䣨yyyy-MM-dd HH:mm:ss�� 
     */
    public static String formatTime(String createTime)
    {
    	//΢��ʱ�䵥λ���룬��ʱ��ת����long���ͣ��ٳ���1000
    	long msgCreateTime = Long.parseLong(createTime) * 1000L;
    	DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	return format.format(new Date(msgCreateTime));
    }
    /**
     * emoji����ת��
     */
    public static String emoji(int hexEmoji)
    {
    	return String.valueOf(Character.toChars(hexEmoji));
    }
    /**
     * ͼ����Ϣ
     */
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	  
}
