package com.zcforit.entity.finance;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhang cheng
 * @version 1.0
 * @description: 现金流量表
 * @date 2022/1/5 20:17
 */
@Data
@Entity
@Table(name="stock_finance_cashflow")
public class CashFlowEntity {
    @Id
    private String tsCode; //str	Y	TS股票代码
    @Id
    private String endDate; //str	Y	报告期
    private String annDate; //str	Y	公告日期
    private String fAnnDate; //str	Y	实际公告日期
    private String compType; //str	Y	公司类型(1一般工商业2银行3保险4证券)
    private String reportType; //str	Y	报表类型
    private String endType; //str	Y	报告期类型
    private String netProfit; //float	Y	净利润
    private String finanExp; //float	Y	财务费用
    private String cFrSaleSg; //float	Y	销售商品、提供劳务收到的现金
    private String recpTaxRends; //float	Y	收到的税费返还
    private String nDeposIncrFi; //float	Y	客户存款和同业存放款项净增加额
    private String nIncrLoansCb; //float	Y	向中央银行借款净增加额
    private String nIncBorrOthFi; //float	Y	向其他金融机构拆入资金净增加额
    private String premFrOrigContr; //float	Y	收到原保险合同保费取得的现金
    private String nIncrInsuredDep; //float	Y	保户储金净增加额
    private String nReinsurPrem; //float	Y	收到再保业务现金净额
    private String nIncrDispTfa; //float	Y	处置交易性金融资产净增加额
    private String ifcCashIncr; //float	Y	收取利息和手续费净增加额
    private String nIncrDispFaas; //float	Y	处置可供出售金融资产净增加额
    private String nIncrLoansOthBank; //float	Y	拆入资金净增加额
    private String nCapIncrRepur; //float	Y	回购业务资金净增加额
    private String cFrOthOperateA; //float	Y	收到其他与经营活动有关的现金
    private String cInfFrOperateA; //float	Y	经营活动现金流入小计
    private String cPaidGoodsS; //float	Y	购买商品、接受劳务支付的现金
    private String cPaidToForEmpl; //float	Y	支付给职工以及为职工支付的现金
    private String cPaidForTaxes; //float	Y	支付的各项税费
    private String nIncrCltLoanAdv; //float	Y	客户贷款及垫款净增加额
    private String nIncrDepCbob; //float	Y	存放央行和同业款项净增加额
    private String cPayClaimsOrigInco; //float	Y	支付原保险合同赔付款项的现金
    private String payHandlingChrg; //float	Y	支付手续费的现金
    private String payCommInsurPlcy; //float	Y	支付保单红利的现金
    private String othCashPayOperAct; //float	Y	支付其他与经营活动有关的现金
    private String stCashOutAct; //float	Y	经营活动现金流出小计
    private String nCashflowAct; //float	Y	经营活动产生的现金流量净额
    private String othRecpRalInvAct; //float	Y	收到其他与投资活动有关的现金
    private String cDispWithdrwlInvest; //float	Y	收回投资收到的现金
    private String cRecpReturnInvest; //float	Y	取得投资收益收到的现金
    private String nRecpDispFiolta; //float	Y	处置固定资产、无形资产和其他长期资产收回的现金净额
    private String nRecpDispSobu; //float	Y	处置子公司及其他营业单位收到的现金净额
    private String stotInflowsInvAct; //float	Y	投资活动现金流入小计
    private String cPayAcqConstFiolta; //float	Y	购建固定资产、无形资产和其他长期资产支付的现金
    private String cPaidInvest; //float	Y	投资支付的现金
    private String nDispSubsOthBiz; //float	Y	取得子公司及其他营业单位支付的现金净额
    private String othPayRalInvAct; //float	Y	支付其他与投资活动有关的现金
    private String nIncrPledgeLoan; //float	Y	质押贷款净增加额
    private String stotOutInvAct; //float	Y	投资活动现金流出小计
    private String nCashflowInvAct; //float	Y	投资活动产生的现金流量净额
    private String cRecpBorrow; //float	Y	取得借款收到的现金
    private String procIssueBonds; //float	Y	发行债券收到的现金
    private String othCashRecpRalFncAct; //float	Y	收到其他与筹资活动有关的现金
    private String stotCashInFncAct; //float	Y	筹资活动现金流入小计
    private String freeCashflow; //float	Y	企业自由现金流量
    private String cPrepayAmtBorr; //float	Y	偿还债务支付的现金
    private String cPayDistDpcpIntExp; //float	Y	分配股利、利润或偿付利息支付的现金
    private String inclDvdProfitPaidScMs; //float	Y	其中:子公司支付给少数股东的股利、利润
    private String othCashpayRalFncAct; //float	Y	支付其他与筹资活动有关的现金
    private String stotCashoutFncAct; //float	Y	筹资活动现金流出小计
    private String nCashFlowsFncAct; //float	Y	筹资活动产生的现金流量净额
    private String effFxFluCash; //float	Y	汇率变动对现金的影响
    private String nIncrCashCashEqu; //float	Y	现金及现金等价物净增加额
    private String cCashEquBegPeriod; //float	Y	期初现金及现金等价物余额
    private String cCashEquEndPeriod; //float	Y	期末现金及现金等价物余额
    private String cRecpCapContrib; //float	Y	吸收投资收到的现金
    private String inclCashRecSaims; //float	Y	其中:子公司吸收少数股东投资收到的现金
    private String unconInvestLoss; //float	Y	未确认投资损失
    private String provDeprAssets; //float	Y	加:资产减值准备
    private String deprFaCogaDpba; //float	Y	固定资产折旧、油气资产折耗、生产性生物资产折旧
    private String amortIntangAssets; //float	Y	无形资产摊销
    private String ltAmortDeferredExp; //float	Y	长期待摊费用摊销
    private String decrDeferredExp; //float	Y	待摊费用减少
    private String incrAccExp; //float	Y	预提费用增加
    private String lossDispFiolta; //float	Y	处置固定、无形资产和其他长期资产的损失
    private String lossScrFa; //float	Y	固定资产报废损失
    private String lossFvChg; //float	Y	公允价值变动损失
    private String investLoss; //float	Y	投资损失
    private String decrDefIncTaxAssets; //float	Y	递延所得税资产减少
    private String incrDefIncTaxLiab; //float	Y	递延所得税负债增加
    private String decrInventories; //float	Y	存货的减少
    private String decrOperPayable; //float	Y	经营性应收项目的减少
    private String incrOperPayable; //float	Y	经营性应付项目的增加
    private String others; //float	Y	其他
    private String imNetCashflowOperAct; //float	Y	经营活动产生的现金流量净额(间接法)
    private String convDebtIntoCap; //float	Y	债务转为资本
    private String convCopbondsDueWithin1y; //float	Y	一年内到期的可转换公司债券
    private String faFncLeases; //float	Y	融资租入固定资产
    private String imNIncrCashEqu; //float	Y	现金及现金等价物净增加额(间接法)
    private String netDismCapitalAdd; //float	Y	拆出资金净增加额
    private String netCashReceSec; //float	Y	代理买卖证券收到的现金净额(元)
    private String creditImpaLoss; //float	Y	信用减值损失
    private String useRightAssetDep; //float	Y	使用权资产折旧
    private String othLossAsset; //float	Y	其他资产减值损失
    private String endBalCash; //float	Y	现金的期末余额
    private String begBalCash; //float	Y	减:现金的期初余额
    private String endBalCashEqu; //float	Y	加:现金等价物的期末余额
    private String begBalCashEqu; //float	Y	减:现金等价物的期初余额
    private String updateFlag; //str	Y	更新标志(1最新）
}
