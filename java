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
