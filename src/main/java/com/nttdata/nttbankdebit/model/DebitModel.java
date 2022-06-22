package com.nttdata.nttbankdebit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "debit")
public class DebitModel {
  @Id
  private String number;

  private String mainAccount;

  private String client;
}
