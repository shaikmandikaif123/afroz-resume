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



@Test
void should_return_list_of_all_the_selected_escalation_types() throws IOException {
    // Given
    List<String> escalationTypesResult = Arrays.asList("AML", "CSR", "SACTION_AND_EMBARGO");
    ComplianceResponseInfo expected = ComplianceResponseInfo.builder()
            .status("APPROVED")
            .attachment(ComplianceResponseAttachment.builder()
                    .id(1L)
                    .name("Alename.pdf")
                    .build())
            .comment("comment")
            .escalationNecessary(true)
            .escalationTypes(escalationTypesResult)
            .build();

    // Read escalation types from JSON
    String jsonFilePath = "src/test/resources/escalationTypes.json";
    ObjectMapper objectMapper = new ObjectMapper();
    EscalationTypes escalationTypes = objectMapper.readValue(new File(jsonFilePath), EscalationTypes.class);

    ResponseEntity<EscalationTypes> responseEntity = ResponseEntity.ok(escalationTypes);
    when(tradeFinanceComplianceClient.getEscalationTypes()).thenReturn(responseEntity);

    // When
    List<String> result = complianceSummaryTemplateHelperService.getEscalationTypesFromComplianceSummary(expected.getEscalationTypes());
    List<String> expectedResult = Arrays.asList("AML", "CSR", "Sanction and Embargo");

    // Then
    assertEquals(expectedResult, result);
}
