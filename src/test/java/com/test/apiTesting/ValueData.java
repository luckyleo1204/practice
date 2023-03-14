package com.test.apiTesting;

import java.util.List;

public class ValueData {

        private List<ValueItems> information;

        public ValueData() {

        }

        public List<ValueItems> getInformation() {
            return information;
        }

        public void setInformation(List<ValueItems> information) {
            this.information = information;
        }

        @Override
        public String toString() {
            return String.format("{information:%s}", information);
        }

    }
