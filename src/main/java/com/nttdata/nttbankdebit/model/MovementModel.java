package com.nttdata.nttbankdebit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "movement")
public class MovementModel {
  @Id
  private String id;

  private String debit;

  private float amount;

  private String type;

  private String date;
}
