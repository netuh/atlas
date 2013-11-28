import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_magnifierindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',82,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('message','g',84,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(6)
createClosureForHtmlPart(7, 2)
invokeTag('link','g',97,['controller':("analyses"),'action':("empiricalStudies")],2)
printHtmlPart(8)
createClosureForHtmlPart(9, 2)
invokeTag('link','g',98,['controller':("analyses"),'action':("analysesByYear")],2)
printHtmlPart(8)
createClosureForHtmlPart(10, 2)
invokeTag('link','g',99,['controller':("analyses"),'action':("badMechanism")],2)
printHtmlPart(8)
createClosureForHtmlPart(11, 2)
invokeTag('link','g',100,['controller':("analyses"),'action':("mechanismUsage")],2)
printHtmlPart(8)
createClosureForHtmlPart(12, 2)
invokeTag('link','g',101,['controller':("analyses"),'action':("authorProductivity")],2)
printHtmlPart(8)
createClosureForHtmlPart(13, 2)
invokeTag('link','g',102,['controller':("analyses"),'action':("mechanismByYear")],2)
printHtmlPart(14)
createClosureForHtmlPart(15, 2)
invokeTag('link','g',106,['controller':("uploader")],2)
printHtmlPart(16)
})
invokeTag('captureBody','sitemesh',110,[:],1)
printHtmlPart(17)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1385667046000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
