package br.com.gama.bankmoney.dto;

public class MoneyDto {
    
    private Integer quantidade;
    private Integer valueNote;

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getValueNote() {
        return valueNote;
    }

    public void setValueNote(Integer valueNote) {
        this.valueNote = valueNote;
    }
    
    public void oneLess(){
        this.quantidade--;
    }
    
}
