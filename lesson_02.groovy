/**
 * Created by igor on 26.10.15.
 */

//def furniture = ['table', 'cabinet', 'sofa', 'chair', 'bed']
//def height
//def width
//def depth
//def color

def table = [:]
table.name = 'table'
table.height = 90
table.width = 120
table.depth = 60
table.color = '#0000FF'

def cabinet = [name : 'cabinet', height : 220, width : 130,   depth : 60,   color : '#F4B400']
def sofa =    ['name' : 'sofa',   'height': 120,'width' : 150, 'depth' : 70, 'color' : '#00FF00']
def chair =   [name : 'chair',   height : 50, width : 40,     depth : 40,   color : '#F4B400']
def bed =     [name : 'bed',     height : 50, width : 160,    depth : 200,  color : '#F4B400']

def furniture = [table, cabinet, sofa, chair, bed]
def outJson = ''

outJson += '{\"furniture\":[\n'
furniture.each {
    def numberOfProperties = it.size() - 1
    outJson += '{'
    it.eachWithIndex {
        its, currentIndex ->
            if (currentIndex != numberOfProperties)
                outJson += its.value.class == java.lang.Integer ? "\"$its.key\":$its.value, " : "\"$its.key\":\"$its.value\", "
            else
                outJson += its.value.class == java.lang.Integer ? "\"$its.key\":$its.value" : "\"$its.key\":\"$its.value\""
    }
    outJson += '},\n'
}
outJson += ']}\n'

def sb = new StringBuffer(outJson)
sb[-5..-5] = ''
println sb


println furniture.find {
    it.width > 100
    it.depth > 100
}

println furniture.findAll {
    it.width == 50
    it.color == '#F4B400'
}
