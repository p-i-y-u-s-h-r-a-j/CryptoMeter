package com.example.cryptometer.fragment.models

data class AuditInfoListItem(
	val coinId: String? = null,
	val auditor: String? = null,
	val auditStatus: Int? = null,
	val reportUrl: String? = null,
	val auditTime: String? = null,
	val score: String? = null,
	val contractAddress: String? = null,
	val contractPlatform: String? = null
)
