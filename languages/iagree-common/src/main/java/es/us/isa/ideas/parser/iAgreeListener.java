// Generated from C:\Users\Juanlu\Desktop\iAgree\iAgree.g4 by ANTLR 4.1
package es.us.isa.ideas.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link iAgreeParser}.
 */
public interface iAgreeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link iAgreeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull iAgreeParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull iAgreeParser.ExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#assig_value}.
	 * @param ctx the parse tree
	 */
	void enterAssig_value(@NotNull iAgreeParser.Assig_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#assig_value}.
	 * @param ctx the parse tree
	 */
	void exitAssig_value(@NotNull iAgreeParser.Assig_valueContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#serviceProvider_prop}.
	 * @param ctx the parse tree
	 */
	void enterServiceProvider_prop(@NotNull iAgreeParser.ServiceProvider_propContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#serviceProvider_prop}.
	 * @param ctx the parse tree
	 */
	void exitServiceProvider_prop(@NotNull iAgreeParser.ServiceProvider_propContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#creationConstraints_def}.
	 * @param ctx the parse tree
	 */
	void enterCreationConstraints_def(@NotNull iAgreeParser.CreationConstraints_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#creationConstraints_def}.
	 * @param ctx the parse tree
	 */
	void exitCreationConstraints_def(@NotNull iAgreeParser.CreationConstraints_defContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#slo}.
	 * @param ctx the parse tree
	 */
	void enterSlo(@NotNull iAgreeParser.SloContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#slo}.
	 * @param ctx the parse tree
	 */
	void exitSlo(@NotNull iAgreeParser.SloContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull iAgreeParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull iAgreeParser.TypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#descriptions}.
	 * @param ctx the parse tree
	 */
	void enterDescriptions(@NotNull iAgreeParser.DescriptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#descriptions}.
	 * @param ctx the parse tree
	 */
	void exitDescriptions(@NotNull iAgreeParser.DescriptionsContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#ag_def}.
	 * @param ctx the parse tree
	 */
	void enterAg_def(@NotNull iAgreeParser.Ag_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#ag_def}.
	 * @param ctx the parse tree
	 */
	void exitAg_def(@NotNull iAgreeParser.Ag_defContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#local_MonitorableProperties}.
	 * @param ctx the parse tree
	 */
	void enterLocal_MonitorableProperties(@NotNull iAgreeParser.Local_MonitorablePropertiesContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#local_MonitorableProperties}.
	 * @param ctx the parse tree
	 */
	void exitLocal_MonitorableProperties(@NotNull iAgreeParser.Local_MonitorablePropertiesContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterOperation(@NotNull iAgreeParser.OperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitOperation(@NotNull iAgreeParser.OperationContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#temporality}.
	 * @param ctx the parse tree
	 */
	void enterTemporality(@NotNull iAgreeParser.TemporalityContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#temporality}.
	 * @param ctx the parse tree
	 */
	void exitTemporality(@NotNull iAgreeParser.TemporalityContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#creationConstraint}.
	 * @param ctx the parse tree
	 */
	void enterCreationConstraint(@NotNull iAgreeParser.CreationConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#creationConstraint}.
	 * @param ctx the parse tree
	 */
	void exitCreationConstraint(@NotNull iAgreeParser.CreationConstraintContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#description}.
	 * @param ctx the parse tree
	 */
	void enterDescription(@NotNull iAgreeParser.DescriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#description}.
	 * @param ctx the parse tree
	 */
	void exitDescription(@NotNull iAgreeParser.DescriptionContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#features}.
	 * @param ctx the parse tree
	 */
	void enterFeatures(@NotNull iAgreeParser.FeaturesContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#features}.
	 * @param ctx the parse tree
	 */
	void exitFeatures(@NotNull iAgreeParser.FeaturesContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#feature}.
	 * @param ctx the parse tree
	 */
	void enterFeature(@NotNull iAgreeParser.FeatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#feature}.
	 * @param ctx the parse tree
	 */
	void exitFeature(@NotNull iAgreeParser.FeatureContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#compensationsInterval}.
	 * @param ctx the parse tree
	 */
	void enterCompensationsInterval(@NotNull iAgreeParser.CompensationsIntervalContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#compensationsInterval}.
	 * @param ctx the parse tree
	 */
	void exitCompensationsInterval(@NotNull iAgreeParser.CompensationsIntervalContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#template}.
	 * @param ctx the parse tree
	 */
	void enterTemplate(@NotNull iAgreeParser.TemplateContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#template}.
	 * @param ctx the parse tree
	 */
	void exitTemplate(@NotNull iAgreeParser.TemplateContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOp(@NotNull iAgreeParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOp(@NotNull iAgreeParser.OpContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#responder_prop}.
	 * @param ctx the parse tree
	 */
	void enterResponder_prop(@NotNull iAgreeParser.Responder_propContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#responder_prop}.
	 * @param ctx the parse tree
	 */
	void exitResponder_prop(@NotNull iAgreeParser.Responder_propContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#agOffer}.
	 * @param ctx the parse tree
	 */
	void enterAgOffer(@NotNull iAgreeParser.AgOfferContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#agOffer}.
	 * @param ctx the parse tree
	 */
	void exitAgOffer(@NotNull iAgreeParser.AgOfferContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#creationConstraints}.
	 * @param ctx the parse tree
	 */
	void enterCreationConstraints(@NotNull iAgreeParser.CreationConstraintsContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#creationConstraints}.
	 * @param ctx the parse tree
	 */
	void exitCreationConstraints(@NotNull iAgreeParser.CreationConstraintsContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#guaranteeTerms}.
	 * @param ctx the parse tree
	 */
	void enterGuaranteeTerms(@NotNull iAgreeParser.GuaranteeTermsContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#guaranteeTerms}.
	 * @param ctx the parse tree
	 */
	void exitGuaranteeTerms(@NotNull iAgreeParser.GuaranteeTermsContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#serviceScope}.
	 * @param ctx the parse tree
	 */
	void enterServiceScope(@NotNull iAgreeParser.ServiceScopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#serviceScope}.
	 * @param ctx the parse tree
	 */
	void exitServiceScope(@NotNull iAgreeParser.ServiceScopeContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#globalDescription}.
	 * @param ctx the parse tree
	 */
	void enterGlobalDescription(@NotNull iAgreeParser.GlobalDescriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#globalDescription}.
	 * @param ctx the parse tree
	 */
	void exitGlobalDescription(@NotNull iAgreeParser.GlobalDescriptionContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#period}.
	 * @param ctx the parse tree
	 */
	void enterPeriod(@NotNull iAgreeParser.PeriodContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#period}.
	 * @param ctx the parse tree
	 */
	void exitPeriod(@NotNull iAgreeParser.PeriodContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#grouped_guaranteeTerm}.
	 * @param ctx the parse tree
	 */
	void enterGrouped_guaranteeTerm(@NotNull iAgreeParser.Grouped_guaranteeTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#grouped_guaranteeTerm}.
	 * @param ctx the parse tree
	 */
	void exitGrouped_guaranteeTerm(@NotNull iAgreeParser.Grouped_guaranteeTermContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#url}.
	 * @param ctx the parse tree
	 */
	void enterUrl(@NotNull iAgreeParser.UrlContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#url}.
	 * @param ctx the parse tree
	 */
	void exitUrl(@NotNull iAgreeParser.UrlContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#guarantee_def}.
	 * @param ctx the parse tree
	 */
	void enterGuarantee_def(@NotNull iAgreeParser.Guarantee_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#guarantee_def}.
	 * @param ctx the parse tree
	 */
	void exitGuarantee_def(@NotNull iAgreeParser.Guarantee_defContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#versionNumber}.
	 * @param ctx the parse tree
	 */
	void enterVersionNumber(@NotNull iAgreeParser.VersionNumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#versionNumber}.
	 * @param ctx the parse tree
	 */
	void exitVersionNumber(@NotNull iAgreeParser.VersionNumberContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#range}.
	 * @param ctx the parse tree
	 */
	void enterRange(@NotNull iAgreeParser.RangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#range}.
	 * @param ctx the parse tree
	 */
	void exitRange(@NotNull iAgreeParser.RangeContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#global_MonitorableProperties}.
	 * @param ctx the parse tree
	 */
	void enterGlobal_MonitorableProperties(@NotNull iAgreeParser.Global_MonitorablePropertiesContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#global_MonitorableProperties}.
	 * @param ctx the parse tree
	 */
	void exitGlobal_MonitorableProperties(@NotNull iAgreeParser.Global_MonitorablePropertiesContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#cuantif}.
	 * @param ctx the parse tree
	 */
	void enterCuantif(@NotNull iAgreeParser.CuantifContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#cuantif}.
	 * @param ctx the parse tree
	 */
	void exitCuantif(@NotNull iAgreeParser.CuantifContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#dateFormat_prop}.
	 * @param ctx the parse tree
	 */
	void enterDateFormat_prop(@NotNull iAgreeParser.DateFormat_propContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#dateFormat_prop}.
	 * @param ctx the parse tree
	 */
	void exitDateFormat_prop(@NotNull iAgreeParser.DateFormat_propContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#expirationTime_prop}.
	 * @param ctx the parse tree
	 */
	void enterExpirationTime_prop(@NotNull iAgreeParser.ExpirationTime_propContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#expirationTime_prop}.
	 * @param ctx the parse tree
	 */
	void exitExpirationTime_prop(@NotNull iAgreeParser.ExpirationTime_propContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#agreementTerms}.
	 * @param ctx the parse tree
	 */
	void enterAgreementTerms(@NotNull iAgreeParser.AgreementTermsContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#agreementTerms}.
	 * @param ctx the parse tree
	 */
	void exitAgreementTerms(@NotNull iAgreeParser.AgreementTermsContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(@NotNull iAgreeParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(@NotNull iAgreeParser.IdContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#period_def}.
	 * @param ctx the parse tree
	 */
	void enterPeriod_def(@NotNull iAgreeParser.Period_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#period_def}.
	 * @param ctx the parse tree
	 */
	void exitPeriod_def(@NotNull iAgreeParser.Period_defContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#agreementTerms_def}.
	 * @param ctx the parse tree
	 */
	void enterAgreementTerms_def(@NotNull iAgreeParser.AgreementTerms_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#agreementTerms_def}.
	 * @param ctx the parse tree
	 */
	void exitAgreementTerms_def(@NotNull iAgreeParser.AgreementTerms_defContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#metrics_prop}.
	 * @param ctx the parse tree
	 */
	void enterMetrics_prop(@NotNull iAgreeParser.Metrics_propContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#metrics_prop}.
	 * @param ctx the parse tree
	 */
	void exitMetrics_prop(@NotNull iAgreeParser.Metrics_propContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#qualifyingCondition}.
	 * @param ctx the parse tree
	 */
	void enterQualifyingCondition(@NotNull iAgreeParser.QualifyingConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#qualifyingCondition}.
	 * @param ctx the parse tree
	 */
	void exitQualifyingCondition(@NotNull iAgreeParser.QualifyingConditionContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#template_def}.
	 * @param ctx the parse tree
	 */
	void enterTemplate_def(@NotNull iAgreeParser.Template_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#template_def}.
	 * @param ctx the parse tree
	 */
	void exitTemplate_def(@NotNull iAgreeParser.Template_defContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#globalPeriod_prop}.
	 * @param ctx the parse tree
	 */
	void enterGlobalPeriod_prop(@NotNull iAgreeParser.GlobalPeriod_propContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#globalPeriod_prop}.
	 * @param ctx the parse tree
	 */
	void exitGlobalPeriod_prop(@NotNull iAgreeParser.GlobalPeriod_propContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#guaranteeTerm}.
	 * @param ctx the parse tree
	 */
	void enterGuaranteeTerm(@NotNull iAgreeParser.GuaranteeTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#guaranteeTerm}.
	 * @param ctx the parse tree
	 */
	void exitGuaranteeTerm(@NotNull iAgreeParser.GuaranteeTermContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(@NotNull iAgreeParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(@NotNull iAgreeParser.ListContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#gmtZone_prop}.
	 * @param ctx the parse tree
	 */
	void enterGmtZone_prop(@NotNull iAgreeParser.GmtZone_propContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#gmtZone_prop}.
	 * @param ctx the parse tree
	 */
	void exitGmtZone_prop(@NotNull iAgreeParser.GmtZone_propContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#temp_properties}.
	 * @param ctx the parse tree
	 */
	void enterTemp_properties(@NotNull iAgreeParser.Temp_propertiesContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#temp_properties}.
	 * @param ctx the parse tree
	 */
	void exitTemp_properties(@NotNull iAgreeParser.Temp_propertiesContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#compensation}.
	 * @param ctx the parse tree
	 */
	void enterCompensation(@NotNull iAgreeParser.CompensationContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#compensation}.
	 * @param ctx the parse tree
	 */
	void exitCompensation(@NotNull iAgreeParser.CompensationContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#entry}.
	 * @param ctx the parse tree
	 */
	void enterEntry(@NotNull iAgreeParser.EntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#entry}.
	 * @param ctx the parse tree
	 */
	void exitEntry(@NotNull iAgreeParser.EntryContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#service}.
	 * @param ctx the parse tree
	 */
	void enterService(@NotNull iAgreeParser.ServiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#service}.
	 * @param ctx the parse tree
	 */
	void exitService(@NotNull iAgreeParser.ServiceContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#monitorableProperties}.
	 * @param ctx the parse tree
	 */
	void enterMonitorableProperties(@NotNull iAgreeParser.MonitorablePropertiesContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#monitorableProperties}.
	 * @param ctx the parse tree
	 */
	void exitMonitorableProperties(@NotNull iAgreeParser.MonitorablePropertiesContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#key_value_prop}.
	 * @param ctx the parse tree
	 */
	void enterKey_value_prop(@NotNull iAgreeParser.Key_value_propContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#key_value_prop}.
	 * @param ctx the parse tree
	 */
	void exitKey_value_prop(@NotNull iAgreeParser.Key_value_propContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#datePeriod_def}.
	 * @param ctx the parse tree
	 */
	void enterDatePeriod_def(@NotNull iAgreeParser.DatePeriod_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#datePeriod_def}.
	 * @param ctx the parse tree
	 */
	void exitDatePeriod_def(@NotNull iAgreeParser.DatePeriod_defContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#definedPeriod_prop}.
	 * @param ctx the parse tree
	 */
	void enterDefinedPeriod_prop(@NotNull iAgreeParser.DefinedPeriod_propContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#definedPeriod_prop}.
	 * @param ctx the parse tree
	 */
	void exitDefinedPeriod_prop(@NotNull iAgreeParser.DefinedPeriod_propContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#initiator_prop}.
	 * @param ctx the parse tree
	 */
	void enterInitiator_prop(@NotNull iAgreeParser.Initiator_propContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#initiator_prop}.
	 * @param ctx the parse tree
	 */
	void exitInitiator_prop(@NotNull iAgreeParser.Initiator_propContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#listArg}.
	 * @param ctx the parse tree
	 */
	void enterListArg(@NotNull iAgreeParser.ListArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#listArg}.
	 * @param ctx the parse tree
	 */
	void exitListArg(@NotNull iAgreeParser.ListArgContext ctx);

	/**
	 * Enter a parse tree produced by {@link iAgreeParser#compensations}.
	 * @param ctx the parse tree
	 */
	void enterCompensations(@NotNull iAgreeParser.CompensationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link iAgreeParser#compensations}.
	 * @param ctx the parse tree
	 */
	void exitCompensations(@NotNull iAgreeParser.CompensationsContext ctx);
}