package com.zcforit.entity.finance;

import lombok.Data;

import javax.persistence.*;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 现金流量表
 * @date 2022/1/5 20:13
 */
@Data
@Entity
@IdClass(IdKeys.class)
@Table(name = "stock_finance_balance")
public class BalanceEntity {
    @Id
    private String tsCode; //	str	Y	TS股票代码
    @Id
    private String endDate; //	str	Y	报告期
    private String annDate; //	str	Y	公告日期
    private String fAnnDate; //	str	Y	实际公告日期
    private String reportType; //	str	Y	报表类型
    private String compType; //	str	Y	公司类型(1一般工商业2银行3保险4证券)
    private String endType; //	str	Y	报告期类型
    private String totalShare; //	float	Y	期末总股本
    private String capRese; //	float	Y	资本公积金
    private String undistrPorfit; //	float	Y	未分配利润
    private String surplusRese; //	float	Y	盈余公积金
    private String specialRese; //	float	Y	专项储备
    private String moneyCap; //	float	Y	货币资金
    private String tradAsset; //	float	Y	交易性金融资产
    private String notesReceiv; //	float	Y	应收票据
    private String accountsReceiv; //	float	Y	应收账款
    private String othReceiv; //	float	Y	其他应收款
    private String prepayment; //	float	Y	预付款项
    private String divReceiv; //	float	Y	应收股利
    private String intReceiv; //	float	Y	应收利息
    private String inventories; //	float	Y	存货
    private String amorExp; //	float	Y	长期待摊费用
//    private String ncaWithin1y; //	float	Y	一年内到期的非流动资产
    private String settRsrv; //	float	Y	结算备付金
    private String loantoOthBankFi; //	float	Y	拆出资金
    private String premiumReceiv; //	float	Y	应收保费
    private String reinsurReceiv; //	float	Y	应收分保账款
    private String reinsurResReceiv; //	float	Y	应收分保合同准备金
    private String purResaleFa; //	float	Y	买入返售金融资产
    private String othCurAssets; //	float	Y	其他流动资产
    private String totalCurAssets; //	float	Y	流动资产合计
    private String faAvailForSale; //	float	Y	可供出售金融资产
    private String htmInvest; //	float	Y	持有至到期投资
    private String ltEqtInvest; //	float	Y	长期股权投资
    private String investRealEstate; //	float	Y	投资性房地产
    private String timeDeposits; //	float	Y	定期存款
    private String othAssets; //	float	Y	其他资产
    private String ltRec; //	float	Y	长期应收款
    private String fixAssets; //	float	Y	固定资产
    private String cip; //	float	Y	在建工程
    private String constMaterials; //	float	Y	工程物资
    private String fixedAssetsDisp; //	float	Y	固定资产清理
    private String producBioAssets; //	float	Y	生产性生物资产
    private String oilAndGasAssets; //	float	Y	油气资产
    private String intanAssets; //	float	Y	无形资产
    private String rAndD; //	float	Y	研发支出
    private String goodwill; //	float	Y	商誉
    private String ltAmorExp; //	float	Y	长期待摊费用
    private String deferTaxAssets; //	float	Y	递延所得税资产
    private String decrInDisbur; //	float	Y	发放贷款及垫款
    private String othNca; //	float	Y	其他非流动资产
    private String totalNca; //	float	Y	非流动资产合计
    private String cashReserCb; //	float	Y	现金及存放中央银行款项
    private String deposInOthBfi; //	float	Y	存放同业和其它金融机构款项
    private String precMetals; //	float	Y	贵金属
    private String derivAssets; //	float	Y	衍生金融资产
    private String rrReinsUnePrem; //	float	Y	应收分保未到期责任准备金
    private String rrReinsOutstdCla; //	float	Y	应收分保未决赔款准备金
    private String rrReinsLinsLiab; //	float	Y	应收分保寿险责任准备金
    private String rrReinsLthinsLiab; //	float	Y	应收分保长期健康险责任准备金
    private String refundDepos; //	float	Y	存出保证金
    private String phPledgeLoans; //	float	Y	保户质押贷款
    private String refundCapDepos; //	float	Y	存出资本保证金
    private String indepAcctAssets; //	float	Y	独立账户资产
    private String clientDepos; //	float	Y	其中：客户资金存款
    private String clientProv; //	float	Y	其中：客户备付金
    private String transacSeatFee; //	float	Y	其中:交易席位费
    private String investAsReceiv; //	float	Y	应收款项类投资
    private String totalAssets; //	float	Y	资产总计
    private String ltBorr; //	float	Y	长期借款
    private String stBorr; //	float	Y	短期借款
    private String cbBorr; //	float	Y	向中央银行借款
    private String deposIbDeposits; //	float	Y	吸收存款及同业存放
    private String loanOthBank; //	float	Y	拆入资金
    private String tradingFl; //	float	Y	交易性金融负债
    private String notesPayable; //	float	Y	应付票据
    private String acctPayable; //	float	Y	应付账款
    private String advReceipts; //	float	Y	预收款项
    private String soldForRepurFa; //	float	Y	卖出回购金融资产款
    private String commPayable; //	float	Y	应付手续费及佣金
    private String payrollPayable; //	float	Y	应付职工薪酬
    private String taxesPayable; //	float	Y	应交税费
    private String intPayable; //	float	Y	应付利息
    private String divPayable; //	float	Y	应付股利
    private String othPayable; //	float	Y	其他应付款
    private String accExp; //	float	Y	预提费用
    private String deferredInc; //	float	Y	递延收益
    private String stBondsPayable; //	float	Y	应付短期债券
    private String payableToReinsurer; //	float	Y	应付分保账款
    private String rsrvInsurCont; //	float	Y	保险合同准备金
    private String actingTradingSec; //	float	Y	代理买卖证券款
    private String actingUwSec; //	float	Y	代理承销证券款
//    private String nonCurLiabDue1y; //	float	Y	一年内到期的非流动负债
    private String othCurLiab; //	float	Y	其他流动负债
    private String totalCurLiab; //	float	Y	流动负债合计
    private String bondPayable; //	float	Y	应付债券
    private String ltPayable; //	float	Y	长期应付款
    private String specificPayables; //	float	Y	专项应付款
    private String estimatedLiab; //	float	Y	预计负债
    private String deferTaxLiab; //	float	Y	递延所得税负债
    private String deferIncNonCurLiab; //	float	Y	递延收益-非流动负债
    private String othNcl; //	float	Y	其他非流动负债
    private String totalNcl; //	float	Y	非流动负债合计
    private String deposOthBfi; //	float	Y	同业和其它金融机构存放款项
    private String derivLiab; //	float	Y	衍生金融负债
    private String depos; //	float	Y	吸收存款
    private String agencyBusLiab; //	float	Y	代理业务负债
    private String othLiab; //	float	Y	其他负债
    private String premReceivAdva; //	float	Y	预收保费
    private String deposReceived; //	float	Y	存入保证金
    private String phInvest; //	float	Y	保户储金及投资款
    private String reserUnePrem; //	float	Y	未到期责任准备金
    private String reserOutstdClaims; //	float	Y	未决赔款准备金
    private String reserLinsLiab; //	float	Y	寿险责任准备金
    private String reserLthinsLiab; //	float	Y	长期健康险责任准备金
    private String indeptAccLiab; //	float	Y	独立账户负债
    private String pledgeBorr; //	float	Y	其中:质押借款
    private String indemPayable; //	float	Y	应付赔付款
    private String policyDivPayable; //	float	Y	应付保单红利
    private String totalLiab; //	float	Y	负债合计
    private String treasuryShare; //	float	Y	减:库存股
    private String ordinRiskReser; //	float	Y	一般风险准备
    private String forexDiffer; //	float	Y	外币报表折算差额
    private String investLossUnconf; //	float	Y	未确认的投资损失
    private String minorityInt; //	float	Y	少数股东权益
    private String totalHldrEqyExcMinInt; //	float	Y	股东权益合计(不含少数股东权益)
    private String totalHldrEqyIncMinInt; //	float	Y	股东权益合计(含少数股东权益)
    private String totalLiabHldrEqy; //	float	Y	负债及股东权益总计
    private String ltPayrollPayable; //	float	Y	长期应付职工薪酬
    private String othCompIncome; //	float	Y	其他综合收益
    private String othEqtTools; //	float	Y	其他权益工具
    private String othEqtToolsPShr; //	float	Y	其他权益工具(优先股)
    private String lendingFunds; //	float	Y	融出资金
    private String accReceivable; //	float	Y	应收款项
    private String stFinPayable; //	float	Y	应付短期融资款
    private String payables; //	float	Y	应付款项
    private String hfsAssets; //	float	Y	持有待售的资产
    private String hfsSales; //	float	Y	持有待售的负债
    private String costFinAssets; //	float	Y	以摊余成本计量的金融资产
    private String fairValueFinAssets; //	float	Y	以公允价值计量且其变动计入其他综合收益的金融资产
    private String cipTotal; //	float	Y	在建工程(合计)(元)
    private String othPayTotal; //	float	Y	其他应付款(合计)(元)
    private String longPayTotal; //	float	Y	长期应付款(合计)(元)
    private String debtInvest; //	float	Y	债权投资(元)
    private String othDebtInvest; //	float	Y	其他债权投资(元)
    private String othEqInvest; //	float	N	其他权益工具投资(元)
    private String othIlliqFinAssets; //	float	N	其他非流动金融资产(元)
    private String othEqPpbond; //	float	N	其他权益工具:永续债(元)
    private String receivFinancing; //	float	N	应收款项融资
    private String useRightAssets; //	float	N	使用权资产
    private String leaseLiab; //	float	N	租赁负债
    private String contractAssets; //	float	Y	合同资产
    private String contractLiab; //	float	Y	合同负债
    private String accountsReceivBill; //	float	Y	应收票据及应收账款
    private String accountsPay; //	float	Y	应付票据及应付账款
    private String othRcvTotal; //	float	Y	其他应收款(合计)（元）
    private String fixAssetsTotal; //	float	Y	固定资产(合计)(元)
    private String updateFlag; //	str	Y	更新标识
}
