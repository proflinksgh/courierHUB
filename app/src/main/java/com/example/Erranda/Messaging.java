package com.example.Erranda;


import com.clxcommunications.xms.ApiConnection;
 import com.clxcommunications.xms.ClxApi;
 import com.clxcommunications.xms.api.MtBatchTextSmsResult;

    public class Messaging {

        public static void main(String[] args) {
            ApiConnection conn = ApiConnection.builder()
                    .servicePlanId("88378a0ee4554b7493daa64f4c559b94")
                    .token("af9afb322b5a455e9c4065f1dc3c1c13")
                    .start();

            try {
                MtBatchTextSmsResult result =
                        conn.createBatch(ClxApi.batchTextSms()
                                .sender("20270746")
                                .addRecipient("+233247058668")
                                .body("Hello")
                                .build());


                System.out.println("The batch ID is " + result.id());

                conn.close();

            } catch (Exception e) {
                System.err.println("Failed to send message: " + e.getMessage());
            }
        }

    }

