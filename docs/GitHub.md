# GitHub - 如何高效搜索一个项目

## 网址

真传一句话，假传万卷书。网址给上，https://github.com/search/advanced。

通过 GitHub 做的图形化界面，可以很快的学会如何快速搜索，里面的选项非常全面，当用熟练之后也就自然而然掌握常用的几个搜索限制条件。

## 常用

| 提示            | 输入          |
| --------------- | ------------- |
| Advanced search | spring boot   |
| language        | language:Java |
| stars           | stars:>1000   |
| forks           | forks:>1000   |

stars 和 forks 数一定程度可以看到项目受欢迎的程度，`Search` 在底部也有，不用再跳到顶部。

![1575175151409](GitHub.assets/1575175151409.png)

## 进阶

| 输入                    | 作用                                                      |
| ----------------------- | --------------------------------------------------------- |
| in:name springboot      | 在项目名出现 springboot                                   |
| in:description 管理系统 | 在项目描述中出现管理系统的项目，下面给出图片              |
| in:readme 微服务        | 在 README 文档中搜索有微服务字眼的项目                    |
| pushed:>2019-01-01      | 在 2019-01-01 后仍有更新的项目，注意日期的写法 YYYY-MM-DD |

![1575175837703](GitHub.assets/1575175837703.png)



## 总结

学会在 GitHub 这个平台搜索项目能够满足自己做项目的需求，也可以在平台上学习如何修 bug，即使一开始自己不会修，也可以观摩其他大神是如何修 bug 的，看就自己总会有所收获。

# GitHub - 不常用的功能

## compare

`https://github.com/vuejs/vue/compare/dev...0.12-csp`

上面举了一个例子，是 vuejs 的 vue 项目，使用了 compare 功能来比较项目不同 commit 的区别，比较的双方是 `dev` 和 `0.12-csp` 。举这个例子，主要是展示 GitHub 网站的 compare 功能。

## tree

`https://github.com/vuejs/vue/tree/dev`

![1575220708886](GitHub.assets/1575220708886.png)

GitHub 网站将每一次 commit 都视为 tree 的一部分，可以在选项框选择某一个 commit 回退查看当时的代码。

