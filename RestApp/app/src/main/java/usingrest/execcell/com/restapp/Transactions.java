package usingrest.execcell.com.restapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Joseph.Pestonit on 1/21/2015.
 */
public class Transactions implements Parcelable {

    public Transactions() {

    }


    String locationCode;
    String districtCode;
    String marketCode;
    String regionCode;
    String trxType;
    String trxDate;
    String trxDate2;
    String salesmanCode;
    String salesmanName;
    String returnTrx;
    String activationType;
    String sn1;
    String departmentCode;
    String departmentDesc;
    String prodCode;
    String prodDesc;
    String phone;
    String prodType;
    int trxNumber;
    int returnQty;
    int quantity;
    float unitPrice;
    float costOfGoods;
    float providerCommission;
    float discount;
    float phoneGP;
    float accGP;
    float tgp;

    public float getTgp() {
        return tgp;
    }

    public void setTgp(float tgp) {
        this.tgp = tgp;
    }

    public int getTrxNumber() {
        return trxNumber;
    }

    public void setTrxNumber(int trxNumber) {
        this.trxNumber = trxNumber;
    }

    public int getReturnQty() {
        return returnQty;
    }

    public void setReturnQty(int returnQty) {
        this.returnQty = returnQty;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public float getCostOfGoods() {
        return costOfGoods;
    }

    public void setCostOfGoods(float costOfGoods) {
        this.costOfGoods = costOfGoods;
    }

    public float getProviderCommission() {
        return providerCommission;
    }

    public void setProviderCommission(float providerCommission) {
        this.providerCommission = providerCommission;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getPhoneGP() {
        return phoneGP;
    }

    public void setPhoneGP(float phoneGP) {
        this.phoneGP = phoneGP;
    }

    public float getAccGP() {
        return accGP;
    }

    public void setAccGP(float accGP) {
        this.accGP = accGP;
    }
    public int describeContents(){
        return  0;
    }




    public Transactions(Parcel in){
        locationCode = in.readString();
        districtCode = in.readString();
        marketCode = in.readString();
        regionCode = in.readString();
        trxType = in.readString();
        trxNumber = in.readInt();
        trxDate = in.readString();
        trxDate2 = in.readString();
        salesmanCode = in.readString();
        salesmanName = in.readString();
        returnTrx = in.readString();
        returnQty = in.readInt();
        quantity = in.readInt();
        activationType = in.readString();
       sn1 = in.readString();
        departmentCode = in.readString();
        departmentDesc = in.readString();
        prodCode = in.readString();
        prodDesc = in.readString();
        phone = in.readString();
        prodType = in.readString();
        unitPrice = in.readFloat();
        costOfGoods = in.readFloat();
        providerCommission = in.readFloat();
        discount = in.readFloat();
        phoneGP = in.readFloat();
        accGP = in.readFloat();
        tgp = in.readFloat();



    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getTrxType() {
        return trxType;
    }

    public void setTrxType(String trxType) {
        this.trxType = trxType;
    }

    public String getTrxDate() {
        return trxDate;
    }

    public void setTrxDate(String trxDate) {
        this.trxDate = trxDate;
    }

    public String getTrxDate2() {
        return trxDate2;
    }

    public void setTrxDate2(String trxDate2) {
        this.trxDate2 = trxDate2;
    }

    public String getSalesmanCode() {
        return salesmanCode;
    }

    public void setSalesmanCode(String salesManCode) {
        this.salesmanCode = salesManCode;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }

    public String getReturnTrx() {
        return returnTrx;
    }

    public void setReturnTrx(String returnTrx) {
        this.returnTrx = returnTrx;
    }

    public String getActivationType() {
        return activationType;
    }

    public void setActivationType(String activationType) {
        this.activationType = activationType;
    }

    public String getSn1() {
        return sn1;
    }

    public void setSn1(String sn1) {
        this.sn1 = sn1;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentDesc() {
        return departmentDesc;
    }

    public void setDepartmentDesc(String departmentDesc) {
        this.departmentDesc = departmentDesc;
    }

    public String getProdCode() {
        return prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(locationCode);
        dest.writeString(locationCode);
        dest.writeString(districtCode);
        dest.writeString(marketCode);
        dest.writeString(regionCode);
        dest.writeString(trxType);
        dest.writeInt(trxNumber);
        dest.writeString(trxDate);
        dest.writeString(trxDate2);
        dest.writeString(salesmanCode);
        dest.writeString(salesmanName);
        dest.writeString(returnTrx);
        dest.writeInt(returnQty);
        dest.writeInt(quantity);
        dest.writeString(activationType);
        dest.writeString(sn1);
        dest.writeString(departmentCode);
        dest.writeString(departmentDesc);
        dest.writeString(prodCode);
        dest.writeString(prodDesc);
        dest.writeString(phone);
        dest.writeString(prodType);
        dest.writeFloat(unitPrice);
        dest.writeFloat(costOfGoods);
        dest.writeFloat(providerCommission);
        dest.writeFloat(discount);
        dest.writeFloat(phoneGP);
        dest.writeFloat(accGP);
        dest.writeFloat(tgp);


    }

    public static final Parcelable.Creator<Transactions> CREATOR = new Parcelable.Creator<Transactions>()
    {
        public Transactions createFromParcel(Parcel in)
        {
            return new Transactions(in);
        }
        public Transactions[] newArray(int size)
        {
            return new Transactions[size];

        }
    };



}
