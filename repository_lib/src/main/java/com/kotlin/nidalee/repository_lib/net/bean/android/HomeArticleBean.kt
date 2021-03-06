package com.example.nidalee.usekotlin.net.bean

/**
 * description:
 * @author 奈德丽
 * @date 2018/8/1 20:03
 */
data class HomeArticleBean(
  val curPage: Int,
  val datas: MutableList<HomeArticleListBean>,
  val offset: Int,
  val over: Boolean,
  val pageCount: Int,
  val size: Int,
  val total: Int
)

data class HomeArticleListBean(
  val apkLink: String,
  val author: String,
  val chapterId: Int,
  val chapterName: String,
  val collect: Boolean,
  val courseId: Int,
  val desc: String,
  val envelopePic: String,
  val fresh: Boolean,
  val id: Int,
  val link: String,
  val niceDate: String,
  val origin: String,
  val projectLink: String,
  val publishTime: Long,
  val superChapterId: Int,
  val superChapterName: String,
  val tags: List<Any>,
  val title: String,
  val type: Int,
  val userId: Int,
  val visible: Int,
  val zan: Int
)