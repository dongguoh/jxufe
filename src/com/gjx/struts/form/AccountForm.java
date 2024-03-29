/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.gjx.struts.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

/** 
 * MyEclipse Struts
 * Creation date: 07-24-2007
 * 
 * XDoclet definition:
 * @struts.form name="accountForm"
 */
public class AccountForm extends ValidatorForm {
	/*
	 * Generated fields
	 */

	/** level property */
	private int level;

	/** password property */
	private String password;

	/** userId property */
	private String userId;

	/** username property */
	private String username;

	/** email property */
	private String email;

	/** repeatedPassword property */
	private String repeatedPassword;

	/*
	 * Generated Methods
	 */

	/** 
	 * Method validate
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	public ActionErrors validator(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}

	/** 
	 * Returns the level.
	 * @return String
	 */
	public int getLevel() {
		return level;
	}

	/** 
	 * Set the level.
	 * @param level The level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/** 
	 * Returns the password.
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	/** 
	 * Set the password.
	 * @param password The password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/** 
	 * Returns the userId.
	 * @return String
	 */
	public String getUserId() {
		return userId;
	}

	/** 
	 * Set the userId.
	 * @param userId The userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/** 
	 * Returns the username.
	 * @return String
	 */
	public String getUsername() {
		return username;
	}

	/** 
	 * Set the username.
	 * @param username The username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/** 
	 * Returns the email.
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	/** 
	 * Set the email.
	 * @param email The email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/** 
	 * Returns the repeatedPassword.
	 * @return String
	 */
	public String getRepeatedPassword() {
		return repeatedPassword;
	}

	/** 
	 * Set the repeatedPassword.
	 * @param repeatedPassword The repeatedPassword to set
	 */
	public void setRepeatedPassword(String repeatedPassword) {
		this.repeatedPassword = repeatedPassword;
	}
}