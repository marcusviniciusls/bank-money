package br.com.gama.bankmoney.entity.enums;

public enum Note {
    
    DOIS(2),
    CINCO(5),
    DEZ(10),
    VINTE(20),
    CINQUENTA(50),
    CEM(100);
    
    private int value;

    Note(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Note toEnum(Integer cod){
        if(cod == null){
            return null;
        }
        for(Note note : Note.values()){
            if(cod.equals(note.getValue())){
                return note;
            }
        }
        throw new IllegalArgumentException("ID inválido: " + cod);
    } 
}
