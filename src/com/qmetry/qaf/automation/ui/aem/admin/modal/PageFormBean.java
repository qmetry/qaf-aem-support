/*******************************************************************************
 * Copyright (c) 2019 Infostretch Corporation
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/
package com.qmetry.qaf.automation.ui.aem.admin.modal;

import static com.qmetry.qaf.automation.ui.aem.coral.CoralLocators.Repository.BUTTON_BY_LABEL_FORMAT;

import java.util.List;

import com.google.gson.Gson;
import com.qmetry.qaf.automation.data.BaseFormDataBean;
import com.qmetry.qaf.automation.ui.aem.admin.pages.PageLocators.CreatePageFormLocators;
import com.qmetry.qaf.automation.ui.aem.coral.Button;
import com.qmetry.qaf.automation.ui.aem.coral.CoralUIComponent;
import com.qmetry.qaf.automation.ui.aem.coral.TagSelector;
import com.qmetry.qaf.automation.ui.annotations.UiElement;


/**
 * @author chirag.jayswal
 *
 */
public class PageFormBean extends BaseFormDataBean implements CreatePageFormLocators {
	
	private String parentPath;

	@UiElement(fieldLoc="", order=0, required=true)
	private String template;
	
	@UiElement(fieldLoc=NAME_LOC_KEY,order=1)
	private String name;
	
	@UiElement(fieldLoc=TITLE_LOC_KEY, order=2, required=true)
	private String title;
	
	@UiElement(fieldLoc=TAGS_LOC_KEY, order=3)
	List<String> tags;
	
	@UiElement(fieldLoc=PAGE_TITLE_LOC_KEY, order=4)
	private String pageTitle;
	
	@UiElement(fieldLoc=NAV_TITLE_LOC_KEY, order=5)
	private String navTitle;
	
	@UiElement(fieldLoc=ALIAS_LOC_KEY,order=6)
	private String alias;
	
	
	public String getParentPath() {
		return parentPath;
	}

	public void setParentPath(String parentPath) {
		this.parentPath = parentPath;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
	@SuppressWarnings("unchecked")
	public void setTags(String tags) {
		this.tags = new Gson().fromJson(tags, List.class);
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public String getNavTitle() {
		return navTitle;
	}

	public void setNavTitle(String navTitle) {
		this.navTitle = navTitle;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public void fillTemplate() {
		CoralUIComponent card = new CoralUIComponent("CQ=[data-foundation-collection-item-id='"+template+"'] coral-card,coral-card:has([coral-card-title:contains('"+template+"'))");
		card.click();
		Button next = new Button(BUTTON_BY_LABEL_FORMAT.locator("Next"));
		next.click();
	}
	
	public void fillTags() {
		if(null!=tags) {
			TagSelector tagInput = new TagSelector(TAGS_LOC_KEY);
			for(String tag: tags) {
				tagInput.sendKeys(tag);
			}
		}
	}
	
	public void fillAlias() {
		CoralUIComponent advanced = new CoralUIComponent(ADVANCE_TAB_LOC_KEY);
		advanced.click();
		CoralUIComponent card = new CoralUIComponent(ALIAS_LOC_KEY);
		card.sendKeys(alias);
	}
	
}
