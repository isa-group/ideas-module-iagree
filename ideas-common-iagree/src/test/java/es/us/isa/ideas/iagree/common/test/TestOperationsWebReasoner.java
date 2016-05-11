/**
 * *****************************************************************************
 * AML is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AML is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with AML. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (C) ISA Research Group - University of Sevilla, 2015 Licensed under
 * GPL (https://github.com/isa-group/aml/blob/master/LICENSE.txt)
 ******************************************************************************
 */
package es.us.isa.ideas.iagree.common.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import es.us.isa.aml.AgreementManager;
import es.us.isa.aml.model.AgreementOffer;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.operations.core.OperationResult;
import es.us.isa.aml.operations.core.csp.AreCompliant;
import es.us.isa.aml.operations.core.csp.ExistInconsistencies;
import es.us.isa.aml.operations.core.csp.WhyAreNotCompliant;
import es.us.isa.aml.operations.noCore.ExistCondInconsTerms;
import es.us.isa.aml.operations.noCore.ExistDeadTerms;
import es.us.isa.aml.util.Config;
import es.us.isa.aml.util.ReasonerType;
import es.us.isa.aml.util.Util;
import es.us.isa.ideas.iagree.common.AnalyzeDelegate;
import java.io.InputStream;

/**
 * @author jdelafuente
 *
 */
public class TestOperationsWebReasoner {

    private static AgreementManager service;
    private static AgreementTemplate model1, model2, model3, model4, model5, azureTemplate, TSCTemplate;
    private static AgreementOffer model6, azureOffer1, azureOffer2, azureOffer3, azureOffer4, TSCCompliant;

    @BeforeClass
    public static void init() {
        InputStream in = AnalyzeDelegate.class
                .getResourceAsStream("/config.json");
        String config = Util.getStringFromInputStream(in);
        
        service = new AgreementManager(config);

        Config.getInstance().setCSPReasoner(ReasonerType.CSPWebReasoner);

        model1 = service
                .createAgreementTemplateFromFile("src/test/resources/core-pack/iagree-core.at");
        model2 = service
                .createAgreementTemplateFromFile("src/test/resources/core-pack/inconsistent.at");
        model3 = service
                .createAgreementTemplateFromFile("src/test/resources/core-pack/dead-terms.at");
        model4 = service
                .createAgreementTemplateFromFile("src/test/resources/core-pack/cond-inconsistent.at");
        model5 = service
                .createAgreementTemplateFromFile("src/test/resources/core-pack/compliant-template.at");
        model6 = service
                .createAgreementOfferFromFile("src/test/resources/core-pack/compliant-offer.ao");
        azureOffer1 = service
                .createAgreementOfferFromFile("src/test/resources/core-pack/azure-compliantOffer.ao");
        azureOffer2 = service
                .createAgreementOfferFromFile("src/test/resources/core-pack/azure-non-Compliant1.ao");
        azureOffer3 = service
                .createAgreementOfferFromFile("src/test/resources/core-pack/azure-non-Compliant2.ao");
        azureOffer4 = service
                .createAgreementOfferFromFile("src/test/resources/core-pack/azure-non-Compliant3.ao");
        azureTemplate = service
                .createAgreementTemplateFromFile("src/test/resources/core-pack/azure-template.at");
        TSCTemplate = service
                .createAgreementTemplateFromFile("src/test/resources/core-pack/TSCTemplate.at");
        TSCCompliant = service
                .createAgreementOfferFromFile("src/test/resources/core-pack/TSCCompliant.ao");
    }

    @Test
    public void testValidation() {
        assertTrue(model1.isValid());
        assertFalse(model2.isValid());
        assertFalse(model3.isValid());
        assertFalse(model4.isValid());
        assertTrue(model5.isValid());
        assertTrue(model6.isValid());
        assertTrue(azureOffer1.isValid());
        assertTrue(azureOffer2.isValid());
        assertTrue(azureOffer3.isValid());
        assertTrue(azureOffer4.isValid());
        assertTrue(azureTemplate.isValid());
        assertTrue(TSCTemplate.isValid());
        assertTrue(TSCCompliant.isValid());
    }

    @Test
    public void testInconsistencyOperation() {
        ExistInconsistencies op = new ExistInconsistencies();
        op.analyze(model1);
        assertFalse(Boolean.valueOf(op.getResult().getExistInconsistencies()
                .toString()));

        op.analyze(model2);
        assertTrue(Boolean.valueOf(op.getResult().getExistInconsistencies()
                .toString()));

        op.analyze(model3);
        assertFalse(Boolean.valueOf(op.getResult().getExistInconsistencies()
                .toString()));

        op.analyze(model4);
        assertFalse(Boolean.valueOf(op.getResult().getExistInconsistencies()
                .toString()));

        op.analyze(model5);
        assertFalse(Boolean.valueOf(op.getResult().getExistInconsistencies()
                .toString()));

        op.analyze(model6);
        assertFalse(Boolean.valueOf(op.getResult().getExistInconsistencies()
                .toString()));

        op.analyze(azureOffer1);
        assertFalse(Boolean.valueOf(op.getResult().getExistInconsistencies()
                .toString()));

        op.analyze(azureOffer2);
        assertFalse(Boolean.valueOf(op.getResult().getExistInconsistencies()
                .toString()));

        op.analyze(azureOffer3);
        assertFalse(Boolean.valueOf(op.getResult().getExistInconsistencies()
                .toString()));

        op.analyze(azureOffer4);
        assertFalse(Boolean.valueOf(op.getResult().getExistInconsistencies()
                .toString()));

        op.analyze(azureTemplate);
        assertFalse(Boolean.valueOf(op.getResult().getExistInconsistencies()
                .toString()));

        op.analyze(TSCTemplate);
        assertFalse(Boolean.valueOf(op.getResult().getExistInconsistencies()
                .toString()));

        op.analyze(TSCCompliant);
        assertFalse(Boolean.valueOf(op.getResult().getExistInconsistencies()
                .toString()));
    }

    @Test
    public void testDeadTermsOperation() {
        ExistDeadTerms op = new ExistDeadTerms();
        op.analyze(model1);
        assertFalse(Boolean.valueOf(op.getResult().getExistDeadTerms()
                .toString()));

        op.analyze(model2);
        assertFalse(Boolean.valueOf(op.getResult().getExistDeadTerms()
                .toString()));

        op.analyze(model3);
        assertTrue(Boolean.valueOf(op.getResult().getExistDeadTerms()
                .toString()));

        op.analyze(model4);
        assertFalse(Boolean.valueOf(op.getResult().getExistDeadTerms()
                .toString()));

        op.analyze(model5);
        assertFalse(Boolean.valueOf(op.getResult().getExistDeadTerms()
                .toString()));

        op.analyze(model6);
        assertFalse(Boolean.valueOf(op.getResult().getExistDeadTerms()
                .toString()));

        op.analyze(azureOffer1);
        assertFalse(Boolean.valueOf(op.getResult().getExistDeadTerms()
                .toString()));

        op.analyze(azureOffer2);
        assertFalse(Boolean.valueOf(op.getResult().getExistDeadTerms()
                .toString()));

        op.analyze(azureOffer3);
        assertFalse(Boolean.valueOf(op.getResult().getExistDeadTerms()
                .toString()));

        op.analyze(azureOffer4);
        assertFalse(Boolean.valueOf(op.getResult().getExistDeadTerms()
                .toString()));

        op.analyze(azureTemplate);
        assertFalse(Boolean.valueOf(op.getResult().getExistDeadTerms()
                .toString()));

        op.analyze(TSCTemplate);
        assertFalse(Boolean.valueOf(op.getResult().getExistDeadTerms()
                .toString()));

        op.analyze(TSCCompliant);
        assertFalse(Boolean.valueOf(op.getResult().getExistDeadTerms()
                .toString()));
    }

    @Test
    public void testCondInconsistentOperation() {
        ExistCondInconsTerms op = new ExistCondInconsTerms();
        op.analyze(model1);
        assertFalse(Boolean.valueOf(op.getResult().getExistCondInconsTerms()
                .toString()));

        op.analyze(model2);
        assertFalse(Boolean.valueOf(op.getResult().getExistCondInconsTerms()
                .toString()));

        op.analyze(model3);
        // TODO here cond incons should be false
        assertTrue(Boolean.valueOf(op.getResult().getExistCondInconsTerms()
                .toString()));

        op.analyze(model4);
        assertTrue(Boolean.valueOf(op.getResult().getExistCondInconsTerms()
                .toString()));

        op.analyze(model5);
        assertFalse(Boolean.valueOf(op.getResult().getExistCondInconsTerms()
                .toString()));

        op.analyze(model6);
        assertFalse(Boolean.valueOf(op.getResult().getExistCondInconsTerms()
                .toString()));

        op.analyze(azureOffer1);
        assertFalse(Boolean.valueOf(op.getResult().getExistCondInconsTerms()
                .toString()));

        op.analyze(azureOffer2);
        assertFalse(Boolean.valueOf(op.getResult().getExistCondInconsTerms()
                .toString()));

        op.analyze(azureOffer3);
        assertFalse(Boolean.valueOf(op.getResult().getExistCondInconsTerms()
                .toString()));

        op.analyze(azureOffer4);
        assertFalse(Boolean.valueOf(op.getResult().getExistCondInconsTerms()
                .toString()));

        op.analyze(azureTemplate);
        assertFalse(Boolean.valueOf(op.getResult().getExistCondInconsTerms()
                .toString()));

        op.analyze(TSCTemplate);
        assertFalse(Boolean.valueOf(op.getResult().getExistCondInconsTerms()
                .toString()));

        op.analyze(TSCCompliant);
        assertFalse(Boolean.valueOf(op.getResult().getExistCondInconsTerms()
                .toString()));
    }

    @Test
    public void testAreCompliant1() {
        AreCompliant op = new AreCompliant();
        op.analyze(model5, model6);
        OperationResult resp = op.getResult();
        assertTrue(resp.getCompliant());
    }

    @Test
    public void testAreCompliant2() {
        AreCompliant op = new AreCompliant();
        op.analyze(azureTemplate, azureOffer1);
        OperationResult resp = op.getResult();
        assertTrue(resp.getCompliant());
    }

    @Test
    public void testAreCompliant3() {
        AreCompliant op = new AreCompliant();
        op.analyze(azureTemplate, azureOffer2);
        OperationResult resp = op.getResult();
        assertFalse(resp.getCompliant());
    }

    @Test
    public void testAreCompliant4() {
        AreCompliant op = new AreCompliant();
        op.analyze(azureTemplate, azureOffer3);
        OperationResult resp = op.getResult();
        assertFalse(resp.getCompliant());
    }

    @Test
    public void testAreCompliant5() {
        AreCompliant op = new AreCompliant();
        op.analyze(azureTemplate, azureOffer4);
        OperationResult resp = op.getResult();
        assertFalse(resp.getCompliant());
    }

    @Test
    public void testAreCompliant6() {
        AreCompliant op = new AreCompliant();
        op.analyze(TSCTemplate, TSCCompliant);
        OperationResult resp = op.getResult();
        assertTrue(resp.getCompliant());
    }

    @Test
    public void testWhyAreNotCompliant1() {
        WhyAreNotCompliant op = new WhyAreNotCompliant();
        op.analyze(azureTemplate, azureOffer1);
        OperationResult resp = op.getResult();
        assertTrue(resp.getCompliant());
    }

    @Test
    public void testWhyAreNotCompliant2() {
        WhyAreNotCompliant op = new WhyAreNotCompliant();
        op.analyze(azureTemplate, azureOffer2);
        OperationResult resp = op.getResult();
        assertFalse(resp.getCompliant());
        assertTrue(resp.getConflicts().toString().equalsIgnoreCase("[G1: MUP < 999;]"));
        assertTrue(resp.getConflictType().equalsIgnoreCase("contradictory offer term"));
        assertTrue(resp.getAffectedTerms().get(0).equalsIgnoreCase("G1: MUP >= 999;"));
    }

    @Test
    public void testWhyAreNotCompliant3() {
        WhyAreNotCompliant op = new WhyAreNotCompliant();
        op.analyze(azureTemplate, azureOffer3);
        OperationResult resp = op.getResult();
        assertFalse(resp.getCompliant());
        assertTrue(resp.getConflicts().toString().equalsIgnoreCase("[G1: MUP >= 9999;]"));
        assertTrue(resp.getConflictType().equalsIgnoreCase("more restrictive offer term"));
        assertTrue(resp.getAffectedTerms().get(0).equalsIgnoreCase("G1: MUP >= 999;"));
    }

    @Test
    public void testWhyAreNotCompliant4() {
        WhyAreNotCompliant op = new WhyAreNotCompliant();
        op.analyze(azureTemplate, azureOffer4);
        OperationResult resp = op.getResult();
        assertFalse(resp.getCompliant());
        assertTrue(resp.getConflicts().toString().equalsIgnoreCase("[ASSIG_Price: Price == 10000;]"));
        assertTrue(resp.getConflictType().equalsIgnoreCase("contradictory offer term"));
        assertTrue(resp.getAffectedTerms().get(0).equalsIgnoreCase("C2: Price == 1192 * MPI;"));
    }

    @Test
    public void testWhyAreNotCompliant5() {
        WhyAreNotCompliant op = new WhyAreNotCompliant();
        op.analyze(TSCTemplate, TSCCompliant);
        OperationResult resp = op.getResult();
        assertTrue(resp.getCompliant());
    }

}
