package UTILIT;

import java.util.Calendar;

public abstract class Datas {
    public static String retornaStringDataAtual(){
        int[] data = new int[3];
        String resultado = "";
        Calendar auxCalendar = Calendar.getInstance();
        data[0] = auxCalendar.get(Calendar.DAY_OF_MONTH);
        data[1] = auxCalendar.get(Calendar.MONTH);
        data[2] = auxCalendar.get(Calendar.YEAR);
        if(data[0] < 10){
            resultado += "0" + data[0] + "/";
        }else{
            resultado += data[0] + "/";
        }
        if(data[1] < 9){
            resultado += "0" + (data[1]+1) + "/";
        }else{
            resultado += (data[1]+1) + "/";
        }
        resultado += data[2];
        return resultado;
    }
    
    public static boolean DataPassouMesmaData(String[] data){
        Calendar dataHoje = Calendar.getInstance();
        //Cria um array int com a data de hoje
        int[] dataHojeArr = new int[3];
        dataHojeArr[0] = dataHoje.get(Calendar.DAY_OF_MONTH);
        dataHojeArr[1] = dataHoje.get(Calendar.MONTH);
        dataHojeArr[2] = dataHoje.get(Calendar.YEAR);
        //Cria um array int com a data
        int[] dataPedido = new int[3];
        dataPedido[0] = Integer.parseInt(data[0]);
        dataPedido[1] = Integer.parseInt(data[1]);
        dataPedido[2] = Integer.parseInt(data[2]);
        //Efetua comparações
        if(dataHojeArr[2] > dataPedido[2]){
            return true;
        }else if(dataHojeArr[2] == dataPedido[2]){
            if (dataHojeArr[1] > dataPedido[1]) {
                return true;
            } else if (dataHojeArr[1] == dataPedido[1]) {
                if (dataHojeArr[0] >= dataPedido[0]) {
                    return true;
                }else{
                    return false;
                }
            } else {
                return false;
            }
        }else{
            return false;
        }      
    }
    public static boolean DataPassouMesmaData(String Data){
        String[] data = new String[3];
        data[0] = Data.substring(0, 2);
        data[1] = Data.substring(3, 5);
        data[2] = Data.substring(6);
        //Converter o mês
        data[1] = Integer.toString(Integer.parseInt(data[1]) - 1);
        //Objeto calendar
        Calendar dataHoje = Calendar.getInstance();
        //Cria um array int com a data de hoje
        int[] dataHojeArr = new int[3];
        dataHojeArr[0] = dataHoje.get(Calendar.DAY_OF_MONTH);
        dataHojeArr[1] = dataHoje.get(Calendar.MONTH);
        dataHojeArr[2] = dataHoje.get(Calendar.YEAR);
        //Cria um array int com a data
        int[] dataPedido = new int[3];
        dataPedido[0] = Integer.parseInt(data[0]);
        dataPedido[1] = Integer.parseInt(data[1]);
        dataPedido[2] = Integer.parseInt(data[2]);
        //Efetua comparações
        if(dataHojeArr[2] > dataPedido[2]){
            return true;
        }else if(dataHojeArr[2] == dataPedido[2]){
            if (dataHojeArr[1] > dataPedido[1]) {
                return true;
            } else if (dataHojeArr[1] == dataPedido[1]) {
                if (dataHojeArr[0] >= dataPedido[0]) {
                    return true;
                }else{
                    return false;
                }
            } else {
                return false;
            }
        }else{
            return false;
        }      
    }
    
    public static boolean MesmoDia(String Data){
        String[] data = new String[3];
        data[0] = Data.substring(0, 2);
        data[1] = Data.substring(3, 5);
        data[2] = Data.substring(6);
        //Converter o mês
        data[1] = Integer.toString(Integer.parseInt(data[1]) - 1);
        //Objeto calendar
        Calendar dataHoje = Calendar.getInstance();
        //Cria um array int com a data de hoje
        int[] dataHojeArr = new int[3];
        dataHojeArr[0] = dataHoje.get(Calendar.DAY_OF_MONTH);
        dataHojeArr[1] = dataHoje.get(Calendar.MONTH);
        dataHojeArr[2] = dataHoje.get(Calendar.YEAR);
        //Cria um array int com a data
        int[] dataPedido = new int[3];
        dataPedido[0] = Integer.parseInt(data[0]);
        dataPedido[1] = Integer.parseInt(data[1]);
        dataPedido[2] = Integer.parseInt(data[2]);
        //Efetua comparações
        return (dataHojeArr[0] == dataPedido[0] && dataHojeArr[1] == dataPedido[1] && dataHojeArr[2] == dataPedido[2]);
    } 
    
    public static boolean DataValidade(String Data){
        String[] data = new String[3];
        data[0] = new String(Data.substring(0, 2));
        data[1] = new String(Data.substring(3, 5));
        data[2] = new String(Data.substring(6));
        //Converter o mês
        data[1] = Integer.toString(Integer.parseInt(data[1]) - 1);
        //Cria um array int com a data
        int[] dataPedido = new int[3];
        dataPedido[0] = Integer.parseInt(data[0]);
        dataPedido[1] = Integer.parseInt(data[1]);
        dataPedido[2] = Integer.parseInt(data[2]);
        if(ehBissexto(dataPedido[2])){
            if(dataPedido[1] > 11) return false;
            else{
                if(dataPedido[1] == 3
                        || dataPedido[1] == 5
                        || dataPedido[1] == 8
                        || dataPedido[1] == 10){
                    if(dataPedido[0] > 30) return false;
                } else if (dataPedido[1] == 0
                        || dataPedido[1] == 2
                        || dataPedido[1] == 4
                        || dataPedido[1] == 6
                        || dataPedido[1] == 7
                        || dataPedido[1] == 9
                        || dataPedido[1] == 11) {
                    if(dataPedido[0] > 31) return false;
                } else {
                    if(dataPedido[0] > 29) return false;
                }
            }
        }else{
            if(dataPedido[1] > 11) return false;
            else{
                if(dataPedido[1] == 3
                        || dataPedido[1] == 5
                        || dataPedido[1] == 8
                        || dataPedido[1] == 10){
                    if(dataPedido[0] > 30) return false;
                } else if (dataPedido[1] == 0
                        || dataPedido[1] == 2
                        || dataPedido[1] == 4
                        || dataPedido[1] == 6
                        || dataPedido[1] == 7
                        || dataPedido[1] == 9
                        || dataPedido[1] == 11) {
                    if(dataPedido[0] > 31) return false;
                } else {
                    if(dataPedido[0] > 28) return false;
                }
            }
        }
        return true;
    }
    
    private static boolean ehBissexto(int ano){
        return ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0));
    }
}
