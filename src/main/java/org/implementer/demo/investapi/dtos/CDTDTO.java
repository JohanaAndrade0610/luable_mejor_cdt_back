package org.implementer.demo.investapi.dtos;

import java.util.List;

public class CDTDTO {
    List<UserInvestmentDTO> cdt;

    public List<UserInvestmentDTO> getCdt() {
        return cdt;
    }

    public CDTDTO(List<UserInvestmentDTO> cdt) {
        this.cdt = cdt;
    }

    public void setCdt(List<UserInvestmentDTO> cdt) {
        this.cdt = cdt;
    }
}
