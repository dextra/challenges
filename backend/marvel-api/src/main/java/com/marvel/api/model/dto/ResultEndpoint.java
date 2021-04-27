package com.marvel.api.model.dto;

@lombok.Data
public class ResultEndpoint {

        private String code;
        private String status;
        private String copyright;
        private String attributionText;
        private String attributionHTML;
        private Data data;
        private String etag;

        public ResultEndpoint(String code, String status, Data data) {
                this.code = code;
                this.status = status;
                this.copyright = "© 2021 MARVEL";
                this.attributionText = "Data provided by Marvel. © 2021 MARVEL";
                this.attributionHTML = "<a href=\"http://marvel.com\">Data provided by Marvel. © 2021 MARVEL</a>";
                this.data = data;
                this.etag = "f97edb38835af098e6115134c8a9a1bf25b96fe4";
        }
}
