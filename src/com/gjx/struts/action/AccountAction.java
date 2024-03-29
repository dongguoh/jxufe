/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.gjx.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

import com.gjx.jxufe.factory.Factory;
import com.gjx.jxufe.vo.Account;
import com.gjx.struts.form.AccountForm;
import com.gjx.util.Constants;

public class AccountAction extends DispatchAction {
	Account account =null;

	// 插入新用户
	public ActionForward insert(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		AccountForm atf = (AccountForm) form;
		if (this.isCancelled(request)) {
			return mapping.findForward(Constants.ADMIN_KEY);
		}
		account = Factory.getAccountDaoImpl().getAccount(atf.getUserId());
		if (null == account) {
			account = new Account();
			this.setAccount(atf);
			Factory.getAccountDaoImpl().insertAccount(account);
			System.out
					.println("*******   插入用户成功 userId=" + account.getUserId());
			List list = null;
			list = Factory.getAccountDaoImpl().getAccountList(request,0,Constants.ACCOUNT_PAGE_LENGTH);
			request.setAttribute(Constants.ACCOUNT_LIST, list);
			return mapping.findForward(Constants.ACCOUNT_LIST);
		} else {
			ActionMessages errors = new ActionMessages();
			errors.add("errors", new ActionMessage("userId.already.exists"));
			this.saveErrors(request, errors);
			System.out.println("*******   这个用户ID已经存在 userId="
					+ account.getUserId());
			return mapping.getInputForward();
		}

	}
//取得用户信息，进入更新页面
	public ActionForward getAccount(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){

		// TODO Auto-generated method stub
		String userId=request.getParameter("userId");
		Account account=Factory.getAccountDaoImpl().getAccount(userId);
		HttpSession session=request.getSession();
		session.setAttribute(Constants.ACCOUNT_KEY,account);
		return mapping.findForward("update");
	
	}
	
	// 更新用户信息
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		AccountForm atf = (AccountForm) form;
		System.out.println("******* atf.getUsername()"+atf.getUsername());
		String userId = request.getParameter("userId");
		account = Factory.getAccountDaoImpl().getAccount(userId);
		if (this.isCancelled(request)) {
			return mapping.findForward(Constants.ADMIN_KEY);
		}		
		if (account!=null ) {			
			this.setAccount(atf);
			Factory.getAccountDaoImpl().updateAccount(account);
			System.out.println("*******   更新用户信息成功 userId="
					+ account.getUserId());
			List list = null;
			list = Factory.getAccountDaoImpl().getAccountList(request,0,Constants.ACCOUNT_PAGE_LENGTH);
			request.setAttribute(Constants.ACCOUNT_LIST, list);
			return mapping.findForward(Constants.ACCOUNT_LIST);
		} else {
			return mapping.getInputForward();
		}

	}

	// 删除一个用户
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userId");
		Object admin = request.getSession().getAttribute(Constants.ADMIN_KEY);
		if (userId != null && (null != admin)) {
			Factory.getAccountDaoImpl().deleteAccount(userId);
			List list = null;
			list = Factory.getAccountDaoImpl().getAccountList(request,0,Constants.ACCOUNT_PAGE_LENGTH);
			request.setAttribute(Constants.ACCOUNT_LIST, list);
			// request.setAttribute("message",
			// "<script>alert('删除成功');</script>");
		}

		return mapping.findForward(Constants.ACCOUNT_LIST);
	}

	// 取得用户列表
	public ActionForward read(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String strPageNum = request.getParameter("pageNum");
		int pageNum = 0;
		if (null != strPageNum && !"".equals(strPageNum)) {
			try {
				pageNum = Integer.parseInt(strPageNum);
			} catch (NumberFormatException nfe) {
				pageNum = 0;
			}
		}
		List list = null;

		list = Factory.getAccountDaoImpl().getAccountList(request, pageNum,
				Constants.ACCOUNT_PAGE_LENGTH);
		//int size = (Integer) request.getAttribute("size");
		request.setAttribute(Constants.ACCOUNT_LIST, list);
		return mapping.findForward(Constants.ACCOUNT_LIST);
	}

	// 注销用户
	public ActionForward logoff(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		request.getSession().removeAttribute(Constants.ADMIN_KEY);

		request.getSession().invalidate();
		return mapping.findForward("logoff");
	}

	// 把从Form取得的用户信息初始化到Account中
	private void setAccount(AccountForm atf) {
		account.setUserId(atf.getUserId());
		account.setPassword(atf.getPassword());
		account.setUsername(atf.getUsername());
		account.setLevel(atf.getLevel());
		account.setEmail(atf.getEmail());
	}
	/*
	 * private Account getAccount(){ return account; }
	 */
}