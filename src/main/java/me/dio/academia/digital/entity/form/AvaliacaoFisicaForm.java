package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.academia.digital.entity.Aluno;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisicaForm {

  @NotNull(message = "Preencha o campo corretamente.")
  @Positive(message = "O ID do aluno não pode ser negativo")
  private Long alunoId;

  @NotNull(message = "Preencha o campo corretamente.")
  @Positive(message = "O peso não pode ser negativo")
  private double peso;

  @NotNull(message = "Preencha o campo corretamente.")
  @Positive(message = "A altura não pode ser negativa")
  private double altura;
}
