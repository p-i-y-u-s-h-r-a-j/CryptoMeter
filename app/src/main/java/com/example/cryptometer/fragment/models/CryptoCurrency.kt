package com.example.cryptometer.fragment.models

import java.io.Serializable

data class CryptoCurrency(
	val symbol: String? = null,
	val selfReportedCirculatingSupply: Double? = null,
	val totalSupply: Double? = null,
	val cmcRank: Double? = null,
	val isActive: Double? = null,
	val circulatingSupply: Double? = null,
	val dateAdded: String? = null,
	val platform: Platform? = null,
	val tags: List<String?>? = null,
	val quotes: List<QuotesItem?>? = null,
	val lastUpdated: String? = null,
	val isAudited: Boolean? = null,
	val name: String? = null,
	val auditInfoList: List<AuditInfoListItem>? = null,
	val marketPairCount: Double? = null,
	val id: Int? = null,
	val slug: String? = null,
	val maxSupply: Double? = null
): Serializable{
	override fun equals(other: Any?): Boolean {
		return super.equals(other)
	}

	override fun hashCode(): Int {
		return super.hashCode()
	}

	override fun toString(): String {
		return super.toString()
	}
}
