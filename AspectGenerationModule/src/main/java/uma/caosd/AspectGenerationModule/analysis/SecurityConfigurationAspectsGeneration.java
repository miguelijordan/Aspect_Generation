package uma.caosd.AspectGenerationModule.analysis;

import java.util.HashSet;
import java.util.Set;

import uma.caosd.AspectGenerationModule.analysis.mapping.MappingSecurityConceptsAspects;
import uma.caosd.AspectGenerationModule.analysis.selectionAlgorithm.AspectsSelectionAlgorithm;
import uma.caosd.AspectGenerationModule.exceptions.AspectsSelectionException;
import uma.caosd.AspectGenerationModule.exceptions.MappingException;
import uma.caosd.AspectualKnowledge.Advisor;
import uma.caosd.AspectualKnowledge.AdvisorConfiguration;
import uma.caosd.AspectualKnowledge.Configuration;
import uma.caosd.AspectualKnowledge.Instance;

public class SecurityConfigurationAspectsGeneration {
	private MappingSecurityConceptsAspects mapping;
	private AspectsSelectionAlgorithm selectionAlgorithm;
	private SDSAnalysis sdsAnalysis;
	
	public SecurityConfigurationAspectsGeneration(SDSAnalysis sdsAnalysis, MappingSecurityConceptsAspects mapping, AspectsSelectionAlgorithm selectionAlgorithm) {
		this.sdsAnalysis = sdsAnalysis;
		this.mapping = mapping;
		this.selectionAlgorithm = selectionAlgorithm;
	}
	
	public Configuration generateSecurityConfigurationToBeDeployed(SDSAnalysis sdsAnalysis) throws AspectsSelectionException, MappingException {
		this.sdsAnalysis = sdsAnalysis;
		Configuration sca = new Configuration();
		Set<Advisor> advisors = getAdvisorsFromMapping(sdsAnalysis.getSecurityConceptToBeDeployed(), true);
		sca.getAdvisor().addAll(advisors);
		Instance instance = new Instance();
		instance.setId(sdsAnalysis.getInstanceID());
		sca.setInstance(instance);
		return sca;	
	}
	
	public Configuration generateSecurityConfigurationToBeUndeployed(SDSAnalysis sdsAnalysis) throws AspectsSelectionException, MappingException {
		this.sdsAnalysis = sdsAnalysis;
		Configuration sca = new Configuration();
		Set<Advisor> advisors =  getAdvisorsFromMapping(sdsAnalysis.getSecurityConceptToBeUnDeployed(), false);
		sca.getAdvisor().addAll(advisors);
		Instance instance = new Instance();
		instance.setId(sdsAnalysis.getInstanceID());
		sca.setInstance(instance);
		return sca;	
	}
	
	private Set<Advisor> getAdvisorsFromMapping(Set<String> ids, boolean deploy) throws MappingException, AspectsSelectionException {
		Set<Advisor> resAdvisors = new HashSet<Advisor>();
		for (String scID : ids) {
			Set<Advisor> candidateAdvisors = mapping.getAdvisors(scID);
			Advisor advisor = selectionAlgorithm.selectAdvisor(candidateAdvisors);
			if (deploy) {
				AdvisorConfiguration config = mapping.getSecurityConceptConfiguration(scID);
				if (config != null) {
					advisor.setConfiguration(config);	
				}
			}
			resAdvisors.add(advisor);
		}
		return resAdvisors;
	}
}
