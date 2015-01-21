package usingrest.execcell.com.restapp;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Joseph.Pestonit on 1/21/2015.
 */
public class TransactionsJSONParser {
    public static ArrayList<Transactions> parseFeed (String content) {
        try {
            JSONArray ar = new JSONArray(content);
            ArrayList<Transactions> tranList = new ArrayList<Transactions>();

            for (int i = 0; i < ar.length(); i++) {
                JSONObject obj = ar.getJSONObject(i);
                Transactions tran = new Transactions( );
                tran.setLocationCode(obj.getString("LocationCode"));
                tran.setDistrictCode(obj.getString("DistrictCode"));
                tran.setMarketCode(obj.getString("MarketCode"));
                tran.setRegionCode(obj.getString("RegionCode"));
                tran.setTrxType(obj.getString("TrxType"));
                tran.setTrxNumber(obj.getInt("TrxNumber"));
                tran.setTrxDate(obj.getString("TrxDate"));
                tran.setTrxDate2(obj.getString("TrxDate2"));
                tran.setSalesmanCode(obj.getString("SalesmanCode"));
                tran.setSalesmanName(obj.getString("SalesmanName"));
                tran.setReturnTrx(obj.getString("ReturnTrx"));
                tran.setReturnQty(obj.getInt("ReturnQty"));
                tran.setQuantity(obj.getInt("Quantity"));
                tran.setActivationType(obj.getString("ActivationType"));
                tran.setSn1(obj.getString("SN1"));
                tran.setDepartmentCode(obj.getString("DepartmentCode"));
                tran.setDepartmentDesc(obj.getString("DepartmentDesc"));
                tran.setProdCode(obj.getString("ProdCode"));
                tran.setProdDesc(obj.getString("ProdDesc"));
                tran.setPhone(obj.getString("Phone"));
                tran.setProdType(obj.getString("ProdType"));
                tran.setUnitPrice((float) obj.getDouble("UnitPrice"));
                tran.setCostOfGoods((float)obj.getDouble("CostOfGoods"));
                tran.setProviderCommission((float)obj.getDouble("ProviderCommission"));
                tran.setDiscount((float)obj.getDouble("Discount"));
                tran.setPhoneGP((float)obj.getDouble("PhoneGP"));
                tran.setAccGP((float)obj.getDouble("AccGP"));
                tran.setTgp((float)obj.getDouble("TGP"));



                tranList.add(tran);
            }return tranList;
        } catch (Exception e) {
            return null;
        }

    }
}