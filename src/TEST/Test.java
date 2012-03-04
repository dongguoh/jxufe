package TEST;

import java.util.Iterator;
import java.util.List;

import com.gjx.jxufe.factory.Factory;
import com.gjx.jxufe.vo.Link;
public class Test {
	public static void main(String[] args) {
		
		
		Link link=new Link(16,2,"你好！","中华人民共和国","donsssgg");
		link.setId(1);
		//Factory.getLinkDaoImpl().insertLink(link);
		//Factory.getLinkTypeDaoImpl().deleteLinkType(7);
		//Factory.getLinkTypeDaoImpl().deleteLinkType(7);
		//Factory.getLinkDaoImpl().deleteLink(15);
		Factory.getLinkDaoImpl().updateLink(link);
		List list=Factory.getLinkDaoImpl().getLinkList();
		Iterator it=list.iterator();
		
		while(it.hasNext()){
			link=(Link)it.next();
			P.rintln(link.getId()+"--"+link.getTypeid()+"--"+link.getName()+"--"+link.getUrl()+"--"+link.getImage());
		}
		
		//link=Factory.getLinkDaoImpl().getLink(16);
		//P.rintln(link.getId()+"--"+link.getTypeid()+"--"+link.getName()+"--"+link.getUrl()+"--"+link.getImage());
		
	}
}
