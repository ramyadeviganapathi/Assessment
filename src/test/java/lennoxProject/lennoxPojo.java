package lennoxProject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class lennoxPojo extends baseClass {
	public lennoxPojo() {
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(id = "samlSignInLink")
	private WebElement sign;

	@CacheLookup
	@FindBy(xpath = "//i[@class='far fa-bars v2-hamburger-menu']")
	private WebElement menu;

	@CacheLookup
	@FindBy(xpath = "//div[@class='v2-hamburger-menu-flyout toggle-open']//following::div[4]")
	private WebElement product;

	@CacheLookup
	@FindBy(xpath = "//div[@class='col-md-12 col-lg-3 col-sm-12 shop-by-category']//descendant::a[12]")
	private WebElement parts;

	@CacheLookup
	@FindBy(xpath = "//div[@class='col-md-12 col-lg-3 col-sm-12 shop-by-category']//descendant::a[14]")
	private WebElement scroll;

	@CacheLookup
	@FindBy(xpath = "(//a[text()='Compressors'])[1]")
	private WebElement compressor;

	@CacheLookup
	@FindBy(xpath = "//input[@id='search']")
	private WebElement searchbox;

	@CacheLookup
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement search;

	@CacheLookup
	@FindBy(xpath = "//ul[@class='menu filters']/descendant::li[18]")
	private WebElement scrollcom;

	@CacheLookup
	@FindBy(xpath = "//div[@class='product-content mt-0 mb-0']/h1")
	private WebElement head;

	@CacheLookup
	@FindBy(xpath = "//div[@class='product-content mt-0 mb-0']/child::p[2]")
	private WebElement head1;

	@CacheLookup
	@FindBy(xpath = "(//button[@type='submit'])[4]")
	private WebElement cart;

	@CacheLookup
	@FindBy(xpath = "//div[@class='col-md-6']/h1")
	private WebElement comhead;

	@CacheLookup
	@FindBy(xpath = "//div[@class='description']/p")
	private WebElement comText;

	public WebElement getComText() {
		return comText;
	}

	public WebElement getComhead() {
		return comhead;
	}

	public WebElement getCart() {
		return cart;
	}

	public WebElement getHead() {
		return head;
	}

	public WebElement getHead1() {
		return head1;
	}

	public WebElement getScrollcom() {
		return scrollcom;
	}

	public WebElement getScroll() {
		return scroll;
	}

	public WebElement getSearchbox() {
		return searchbox;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getCompressor() {
		return compressor;
	}

	public WebElement getParts() {
		return parts;
	}

	public WebElement getProduct() {
		return product;
	}

	public void setProduct(WebElement product) {
		this.product = product;
	}

	public WebElement getMenu() {
		return menu;
	}

	public WebElement getSign() {
		return sign;
	}

}
