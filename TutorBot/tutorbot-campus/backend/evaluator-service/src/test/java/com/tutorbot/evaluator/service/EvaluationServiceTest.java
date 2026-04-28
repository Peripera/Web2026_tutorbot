package com.tutorbot.evaluator.service;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.tutorbot.evaluator.ollama.OllamaService;
import com.tutorbot.evaluator.model.EvaluationResult;
import com.tutorbot.evaluator.repository.EvaluationResultRepository;

class EvaluationServiceTest {

    @Test
    void shouldReturnPersistedEvaluations() {
        EvaluationResultRepository repository = Mockito.mock(EvaluationResultRepository.class);
        OllamaService ollamaService = Mockito.mock(OllamaService.class);
        EvaluationGuardService guard = Mockito.mock(EvaluationGuardService.class);

        EvaluationResult evaluationResult = new EvaluationResult();
        evaluationResult.setScore(92);

        Mockito.when(repository.findAll()).thenReturn(List.of(evaluationResult));

        EvaluationService service = new EvaluationService(repository, ollamaService, guard);

        assertEquals(92, service.findAll().get(0).score());
    }
}