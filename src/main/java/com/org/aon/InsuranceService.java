package com.org.aon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.ObjectFilter;
import org.kie.api.runtime.rule.FactHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.aon.to.Customer;
import com.org.aon.to.Quotes;

@Service
public class InsuranceService {

    private static Logger log = LoggerFactory.getLogger(InsuranceService.class);

    private final KieContainer kieContainer;

    @Autowired
    public InsuranceService(KieContainer kieContainer) {
        log.info("Initialising a new insurance session.");
        this.kieContainer = kieContainer;
    }

    /**
     * Create a new session, insert a customer's details and fire rules to
     * determine what kind of quotes is to be issued.
     */
    public List<Quotes> getQuotes(Customer customer) {
        KieSession kieSession = kieContainer.newKieSession("quotesSession");
        kieSession.insert(customer);
        kieSession.fireAllRules();
        List<Quotes> quotesList = findQuotes(kieSession);
        kieSession.dispose();
        return quotesList;
    }
    
    /**
     * Search the {@link KieSession} for quotes.
     */
    private List<Quotes> findQuotes(KieSession kieSession) {
        
        // Find all quotes.
        ObjectFilter quotesFilter = new ObjectFilter() {
           // @Override
            public boolean accept(Object object) {
                if (Quotes.class.equals(object.getClass())) return true;
                if (Quotes.class.equals(object.getClass().getSuperclass())) return true;
                return false;
            }
        };

        // printFactsMessage(kieSession);
        
        List<Quotes> quotesList = new ArrayList<Quotes>();
        for (FactHandle handle : kieSession.getFactHandles(quotesFilter)) {
        	quotesList.add((Quotes) kieSession.getObject(handle));
        }
        if (quotesList.size() == 0) {
            return null;
        }
        return quotesList;
    }
    
    /**
     * Print out details of all facts in working memory.
     * Handy for debugging.
     */
    @SuppressWarnings("unused")
    private void printFactsMessage(KieSession kieSession) {
        Collection<FactHandle> allHandles = kieSession.getFactHandles();
        
        String msg = "\nAll facts:\n";
        for (FactHandle handle : allHandles) {
            msg += "    " + kieSession.getObject(handle) + "\n";
        }
        System.out.println(msg);
    }

}
