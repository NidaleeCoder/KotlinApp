package com.kotlin.nidalee.repository_lib.net.bean.android

data class Children(
  val children: List<Any>,
  val courseId: Int,
  val id: Int,
  val name: String,
  val order: Int,
  val parentChapterId: Int,
  val visible: Int
)