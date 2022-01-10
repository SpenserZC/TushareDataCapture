package com.zcforit.entity.finance;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 收入表
 * @date 2022/1/5 20:08
 */
@Data
//@Entity
//@Table(name="stock_finance_income")
public class IncomeEntity {
    @Id
    private String tsCode; //	str	Y	TS代码
    @Id
    private String endDate; //	str	Y	报告期
    private String annDate; //	str	Y	公告日期
    private String fAnnDate; //	str	Y	实际公告日期
    private String reportType; //	str	Y	报告类型 见底部表
    private String compType; //	str	Y	公司类型(1一般工商业2银行3保险4证券)
    private String endType; //	str	Y	报告期类型
    private String basicEps; //	float	Y	基本每股收益
    private String dilutedEps; //	float	Y	稀释每股收益
    private String totalRevenue; //	float	Y	营业总收入
    private String revenue; //	float	Y	营业收入
    private String intIncome; //	float	Y	利息收入
    private String premEarned; //	float	Y	已赚保费
    private String commIncome; //	float	Y	手续费及佣金收入
    private String nCommisIncome; //	float	Y	手续费及佣金净收入
    private String nOthIncome; //	float	Y	其他经营净收益
    private String nOthBIncome; //	float	Y	加:其他业务净收益
    private String premIncome; //	float	Y	保险业务收入
    private String outPrem; //	float	Y	减:分出保费
    private String unePremReser; //	float	Y	提取未到期责任准备金
    private String reinsIncome; //	float	Y	其中:分保费收入
    private String nSecTbIncome; //	float	Y	代理买卖证券业务净收入
    private String nSecUwIncome; //	float	Y	证券承销业务净收入
    private String nAssetMgIncome; //	float	Y	受托客户资产管理业务净收入
    private String othBIncome; //	float	Y	其他业务收入
    private String fvValueChgGain; //	float	Y	加:公允价值变动净收益
    private String investIncome; //	float	Y	加:投资净收益
    private String assInvestIncome; //	float	Y	其中:对联营企业和合营企业的投资收益
    private String forexGain; //	float	Y	加:汇兑净收益
    private String totalCogs; //	float	Y	营业总成本
    private String operCost; //	float	Y	减:营业成本
    private String intExp; //	float	Y	减:利息支出
    private String commExp; //	float	Y	减:手续费及佣金支出
    private String bizTaxSurchg; //	float	Y	减:营业税金及附加
    private String sellExp; //	float	Y	减:销售费用
    private String adminExp; //	float	Y	减:管理费用
    private String finExp; //	float	Y	减:财务费用
    private String assetsImpairLoss; //	float	Y	减:资产减值损失
    private String premRefund; //	float	Y	退保金
    private String compensPayout; //	float	Y	赔付总支出
    private String reserInsurLiab; //	float	Y	提取保险责任准备金
    private String divPayt; //	float	Y	保户红利支出
    private String reinsExp; //	float	Y	分保费用
    private String operExp; //	float	Y	营业支出
    private String compensPayoutRefu; //	float	Y	减:摊回赔付支出
    private String insurReserRefu; //	float	Y	减:摊回保险责任准备金
    private String reinsCostRefund; //	float	Y	减:摊回分保费用
    private String otherBusCost; //	float	Y	其他业务成本
    private String operateProfit; //	float	Y	营业利润
    private String nonOperIncome; //	float	Y	加:营业外收入
    private String nonOperExp; //	float	Y	减:营业外支出
    private String ncaDisploss; //	float	Y	其中:减:非流动资产处置净损失
    private String totalProfit; //	float	Y	利润总额
    private String incomeTax; //	float	Y	所得税费用
    private String nIncome; //	float	Y	净利润(含少数股东损益)
    private String nIncomeAttrP; //	float	Y	净利润(不含少数股东损益)
    private String minorityGain; //	float	Y	少数股东损益
    private String othComprIncome; //	float	Y	其他综合收益
    private String tComprIncome; //	float	Y	综合收益总额
    private String comprIncAttrP; //	float	Y	归属于母公司(或股东)的综合收益总额
    private String comprIncAttrMS; //	float	Y	归属于少数股东的综合收益总额
    private String ebit; //	float	Y	息税前利润
    private String ebitda; //	float	Y	息税折旧摊销前利润
    private String insuranceExp; //	float	Y	保险业务支出
    private String undistProfit; //	float	Y	年初未分配利润
    private String distableProfit; //	float	Y	可分配利润
    private String rdExp; //	float	Y	研发费用
    private String finExpIntExp; //	float	Y	财务费用:利息费用
    private String finExpIntInc; //	float	Y	财务费用:利息收入
    private String transferSurplusRese; //	float	Y	盈余公积转入
    private String transferHousingImprest; //	float	Y	住房周转金转入
    private String transferOth; //	float	Y	其他转入
    private String adjLossgain; //	float	Y	调整以前年度损益
    private String withdraLegalSurplus; //	float	Y	提取法定盈余公积
    private String withdraLegalPubfund; //	float	Y	提取法定公益金
    private String withdraBizDevfund; //	float	Y	提取企业发展基金
    private String withdraReseFund; //	float	Y	提取储备基金
    private String withdraOthErsu; //	float	Y	提取任意盈余公积金
    private String workersWelfare; //	float	Y	职工奖金福利
    private String distrProfitShrhder; //	float	Y	可供股东分配的利润
    private String prfsharePayableDvd; //	float	Y	应付优先股股利
    private String comsharePayableDvd; //	float	Y	应付普通股股利
    private String capitComstockDiv; //	float	Y	转作股本的普通股股利
    private String netAfterNrLpCorrect; //	float	N	扣除非经常性损益后的净利润（更正前）
    private String creditImpaLoss; //	float	N	信用减值损失
    private String netExpoHedgingBenefits; //	float	N	净敞口套期收益
    private String othImpairLossAssets; //	float	N	其他资产减值损失
    private String totalOpcost; //	float	N	营业总成本（二）
    private String amodcostFinAssets; //	float	N	以摊余成本计量的金融资产终止确认收益
    private String othIncome; //	float	N	其他收益
    private String assetDispIncome; //	float	N	资产处置收益
    private String continuedNetProfit; //	float	N	持续经营净利润
    private String endNetProfit; //	float	N	终止经营净利润
    private String updateFlag; //	str	Y	更新标识
}
