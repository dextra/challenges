package dev.dextra.newsapp.api.model.enums

import dev.dextra.newsapp.R

enum class Country(private val resId: Int) : BaseDataEnum {

    ALL(R.string.ALL_COUNTRIES), US(R.string.US), CA(R.string.CA), BR(R.string.BR), AE(R.string.AE), AR(R.string.AR),
    AT(R.string.AT), AU(R.string.AU), BE(R.string.BE), BG(R.string.BG), CH(R.string.CH), CN(R.string.CN),
    CO(R.string.CO), CU(R.string.CU), CZ(R.string.CZ), DE(R.string.DE), EG(R.string.EG), FR(R.string.FR), GB(R.string.GB),
    GR(R.string.GR), HK(R.string.HK), HU(R.string.HU), ID(R.string.ID), IE(R.string.IE), IL(R.string.IL),
    IN(R.string.IN), IT(R.string.IT), JP(R.string.JP), KR(R.string.KR), LT(R.string.LT), LV(R.string.LV),
    MA(R.string.MA), MX(R.string.MX), MY(R.string.MY), NG(R.string.NG), NL(R.string.NL), NO(R.string.NO),
    NZ(R.string.NZ), PH(R.string.PH), PL(R.string.PL), PT(R.string.PT), RO(R.string.RO), RS(R.string.RS),
    RU(R.string.RU), SA(R.string.SA), SE(R.string.SE), SG(R.string.SG), SI(R.string.SI), SK(R.string.SK),
    TH(R.string.TH), TR(R.string.TR), TW(R.string.TW), UA(R.string.UA), VE(R.string.VE),
    ZA(R.string.ZA);

    override fun getRes(): Int {
        return resId
    }
}