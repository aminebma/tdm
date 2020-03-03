package exo3

import jdk.nashorn.internal.runtime.PrototypeObject

class ProductManager {

    fun getTypeNumber(productList:List<Product>, type:String):Int{
        var nb:Int=0
        for(p:Product in productList)
            if (p.getType() == type) nb++
        return nb
    }

    fun getPacks(productList:List<Product>, name:String):List<Pack>{
        var packList:MutableList<Pack> = mutableListOf()
        for(p:Product in productList){
            when(p){
                is Pack -> {
                    for(s:Smartphone in p.smartphoneList.keys) if(s.name == name) packList.add(p)
                }
            }
        }
        return packList
    }

    fun getTotalPrice(productList:List<Product>):Long{
        var total = 0L
        var nbSmart:Int = 0
        for(p:Product in productList){
            when(p){
                is Pack->{
                    total+=p.price*p.Qte
                }
                is Smartphone->{
                    nbSmart=p.Qte
                    for(pk:Pack in getPacks(productList,p.name))
                        nbSmart-=pk.smartphoneList.getValue(p)
                    total+=nbSmart*p.price
                }
            }
        }
        return total
    }
}