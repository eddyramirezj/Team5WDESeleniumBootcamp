package pom;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditCards extends BaseClass {

    public CreditCards() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath="//a[@data-pt-name='cc_slate_edge_allcc_name']//parent::h3//following-sibling::div[@class='cardmember-offer']/p[@class='cardmember-offer-split']/b")
    public WebElement slateEdgeOffer;

    @FindBy (xpath="//a[@data-pt-name='cc_slate_edge_allcc_name']//parent::h3//following-sibling::div[@class='purchase-apr']/p")
    public WebElement slateEdgeAPR;

    @FindBy (xpath="//a[@data-pt-name='cc_slate_edge_allcc_name']//parent::h3//following-sibling::div[@class='annual-fee']/p")
    public WebElement slateEdgeAnnualFee;

    @FindBy (xpath="//a[@data-pt-name='cc_freedom_ulim_allcc_name']//parent::h3//following-sibling::div[@class='cardmember-offer']/p[@class='cardmember-offer-split']/b")
    public WebElement freeUnlimitedOffer;

    @FindBy (xpath="//a[@data-pt-name='cc_freedom_ulim_allcc_name']//parent::h3//following-sibling::div[@class='purchase-apr']/p")
    public WebElement freeUnlimitedAPR;

    @FindBy (xpath="//a[@data-pt-name='cc_freedom_ulim_allcc_name']//parent::h3//following-sibling::div[@class='annual-fee']/p")
    public WebElement freeUnlimitedAnnualFee;

    @FindBy (xpath="//a[@data-pt-name='cc_freedomflex_allcc_name']//parent::h3//following-sibling::div[@class='cardmember-offer']/p[@class='cardmember-offer-split']/b")
    public WebElement freeFlexOffer;

    @FindBy (xpath="//a[@data-pt-name='cc_freedomflex_allcc_name']//parent::h3//following-sibling::div[@class='purchase-apr']/p")
    public WebElement freeFlexAPR;

    @FindBy (xpath="//a[@data-pt-name='cc_freedomflex_allcc_name']//parent::h3//following-sibling::div[@class='annual-fee']/p")
    public WebElement freeFlexAnnualFee;

    @FindBy (xpath="//a[@data-pt-name='cc_freedom_student_allcc_name']//parent::h3//following-sibling::div[@class='cardmember-offer']/p[@class='cardmember-offer-split']/b")
    public WebElement freeStudOffer;

    @FindBy (xpath="//a[@data-pt-name='cc_freedom_student_allcc_name']//parent::h3//following-sibling::div[@class='purchase-apr']/p")
    public WebElement freeStudAPR;

    @FindBy (xpath="//a[@data-pt-name='cc_freedom_student_allcc_name']//parent::h3//following-sibling::div[@class='annual-fee']/p")
    public WebElement freeStudAnnualFee;

    @FindBy (xpath="//a[@data-pt-name='cc_sapphire_allcc_name']//parent::h3//following-sibling::div[@class='cardmember-offer']/p[@class='cardmember-offer-split']/b")
    public WebElement saphPrefOffer;

    @FindBy (xpath="//a[@data-pt-name='cc_sapphire_allcc_name']//parent::h3//following-sibling::div[@class='purchase-apr']/p")
    public WebElement saphPrefAPR;

    @FindBy (xpath="//a[@data-pt-name='cc_sapphire_allcc_name']//parent::h3//following-sibling::div[@class='annual-fee']/p")
    public WebElement saphPrefAnnualFee;

    @FindBy (xpath="//a[@data-pt-name='cc_sapphire_res_allcc_name']//parent::h3//following-sibling::div[@class='cardmember-offer']/p[@class='cardmember-offer-split']/b")
    public WebElement saphResOffer;

    @FindBy (xpath="//a[@data-pt-name='cc_sapphire_res_allcc_name']//parent::h3//following-sibling::div[@class='purchase-apr']/p")
    public WebElement saphResAPR;

    @FindBy (xpath="//a[@data-pt-name='cc_sapphire_res_allcc_name']//parent::h3//following-sibling::div[@class='annual-fee']/p")
    public WebElement saphResAnnualFee;

    @FindBy (xpath="//a[@data-pt-name='cc_swa_plus_allcc_name']//parent::h3//following-sibling::div[@class='cardmember-offer']/p[@class='cardmember-offer-split']/b")
    public WebElement southPlusOffer;

    @FindBy (xpath="//a[@data-pt-name='cc_swa_plus_allcc_name']//parent::h3//following-sibling::div[@class='purchase-apr']/p")
    public WebElement southPlusAPR;

    @FindBy (xpath="//a[@data-pt-name='cc_swa_plus_allcc_name']//parent::h3//following-sibling::div[@class='annual-fee']/p")
    public WebElement southPlusAnnualFee;

    @FindBy (xpath="//a[@data-pt-name='cc_swa_pri_allcc_name']//parent::h3//following-sibling::div[@class='cardmember-offer']/p[@class='cardmember-offer-split']/b")
    public WebElement southPriorOffer;

    @FindBy (xpath="//a[@data-pt-name='cc_swa_pri_allcc_name']//parent::h3//following-sibling::div[@class='purchase-apr']/p")
    public WebElement southPriorAPR;

    @FindBy (xpath="//a[@data-pt-name='cc_swa_pri_allcc_name']//parent::h3//following-sibling::div[@class='annual-fee']/p")
    public WebElement southPriorAnnualFee;

    @FindBy (xpath="//a[@data-pt-name='cc_swa_prem_allcc_name']//parent::h3//following-sibling::div[@class='cardmember-offer']/p[@class='cardmember-offer-split']/b")
    public WebElement southPremOffer;

    @FindBy (xpath="//a[@data-pt-name='cc_swa_prem_allcc_name']//parent::h3//following-sibling::div[@class='purchase-apr']/p")
    public WebElement southPremAPR;

    @FindBy (xpath="//a[@data-pt-name='cc_swa_prem_allcc_name']//parent::h3//following-sibling::div[@class='annual-fee']/p")
    public WebElement southPremAnnualFee;

    @FindBy (xpath="//a[@data-pt-name='cc_united_exp_allcc_name']//parent::h3//following-sibling::div[@class='cardmember-offer']/p[@class='cardmember-offer-split']/b")
    public WebElement unitedExplorOffer;

    @FindBy (xpath="//a[@data-pt-name='cc_united_exp_allcc_name']//parent::h3//following-sibling::div[@class='purchase-apr']/p")
    public WebElement unitedExplorAPR;

    @FindBy (xpath="//a[@data-pt-name='cc_united_exp_allcc_name']//parent::h3//following-sibling::div[@class='annual-fee']/p")
    public WebElement unitedExplorAnnualFee;










}
