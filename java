public List<String> getEscalationTypesFromComplianceSummary(List<String> selectedEscalationTypeCodes) {
    return Optional.ofNullable(this.tradeFinanceComplianceClient.getEscalationTypes())
            .map(ResponseEntity::getBody)
            .map(ComplianceSummary::getEscalationTypes)
            .filter(escalationTypes -> ObjectUtils.isNotEmpty(selectedEscalationTypeCodes))
            .map(escalationTypes -> escalationTypes.stream()
                    .filter(escalationType -> selectedEscalationTypeCodes.contains(escalationType.getCode()))
                    .map(EscalationType::getName)
                    .collect(Collectors.toList()))
            .orElse(Collections.emptyList());
}


import org.apache.commons.lang3.ObjectUtils;

public List<String> getEscalationTypesFromComplianceSummary(List<String> selectedEscalationTypeCodes) {
    return Optional.ofNullable(this.tradeFinanceComplianceClient.getEscalationTypes())
            .map(ResponseEntity::getBody)
            .map(EscalationTypes::getEscalationTypes)
            .filter(escalationTypes -> ObjectUtils.isNotEmpty(selectedEscalationTypeCodes))
            .map(escalationTypes -> escalationTypes.stream()
                    .filter(escalationType -> selectedEscalationTypeCodes.contains(escalationType.getCode()))
                    .map(EscalationType::getName)
                    .toList()) // Using .toList() for Java 16+
            .orElse(Collections.emptyList());
}
