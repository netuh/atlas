package br.ufpe.cin.atlas.magnifier



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MechanismController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Mechanism.list(params), model:[mechanismInstanceCount: Mechanism.count()]
    }

    def show(Mechanism mechanismInstance) {
        respond mechanismInstance
    }

    def create() {
        respond new Mechanism(params)
    }
	
	def analyseByQuantity() {
		def mechanismByQuantity = [:]
		def avalableStudies = []
		
		if (params.conference != null && params.conference != "All") {
			PrimaryStudy.findAllByConferenceSource(params.conference).each {
				avalableStudies.addAll(it.getMechanisms())
			}
		} else {
			avalableStudies = Mechanism.all
		}
		
		avalableStudies.each {
			def empContent = it.getContent()
			if (!mechanismByQuantity.containsKey(empContent)){
				mechanismByQuantity.put(empContent, [it])
			} else {
				mechanismByQuantity.get(empContent).add(it)
			}
		}
		def importMechanismByQuantity = [:]
		mechanismByQuantity.each {
			if (it.value.size() > 1){
				importMechanismByQuantity.put(it.key, it.value.size())
			}
		}
		
		mechanismByQuantity= mechanismByQuantity.sort { it.value.size()}
		
		[ list:importMechanismByQuantity,fullList:mechanismByQuantity , conference:params.conference ]
	}
	
	def analyseByEmpiricalMethod() {
		def mechanismByEmpMethods = [:]
		def avalableStudies = []
		
		if (params.conference != null && params.conference != "All") {
			PrimaryStudy.findAllByConferenceSource(params.conference).each {
				avalableStudies.addAll(it.getMechanisms())
			}
		} else {
			avalableStudies = Mechanism.all
		}
		
		avalableStudies.each {
			def empMethod = it.getOwner().getStudyType()
			if (!mechanismByEmpMethods.containsKey(empMethod)){
				mechanismByEmpMethods.put(empMethod, [it])
			} else {
				mechanismByEmpMethods.get(empMethod).add(it)
			}
		}
		[ list:mechanismByEmpMethods , conference:params.conference ]
	}
	
	def analyseByYearNew() {
		def studyByYear = [:]
		def avalableMechanism = []
		def primaryStudies = []
		if (params.conference != null && params.conference != "All") {
			primaryStudies = PrimaryStudy.findAllByConferenceSource(params.conference)
		} else {
			primaryStudies = PrimaryStudy.all
		}
		
		primaryStudies.each {
			def studyYear = it.getYear()
			def studyList;
			if (!studyByYear.containsKey(studyYear)){
				studyList = []
				studyByYear.put(studyYear, studyList)
			} else {
				studyList = studyByYear.get(studyYear)
			}
			if (it.getMechanisms()) {
				studyList.add(it)
			}
		}
		studyByYear= studyByYear.sort { it.key}
		def finalListStudies = []
		studyByYear.each {
			def year = it.key
			def studiesByYear = []
			primaryStudies.each {
				if (it.year == year)
					studiesByYear.add(it)
			}
			finalListStudies.add([year:it.key, mech:it.value.size(), total:studiesByYear.size()])
		}
		[ list:studyByYear, newList : finalListStudies ]
	}
	
	def analyseByYear() {
		def mechanismByYear = [:]
		def avalableMechanism = []
		
		if (params.conference != null && params.conference != "All") {
			PrimaryStudy.findAllByConferenceSource(params.conference).each {
				avalableMechanism.addAll(it.getMechanisms())
			}
		} else {
			avalableMechanism = Mechanism.all
		}
		
		avalableMechanism.each {
			def mechYear = it.getOwner().getYear()
			if (!mechanismByYear.containsKey(mechYear)){
				mechanismByYear.put(mechYear, [it])
			} else {
				mechanismByYear.get(mechYear).add(it)
			}
		}
		mechanismByYear= mechanismByYear.sort { it.key}
		[ list:mechanismByYear ]
	}

    @Transactional
    def save(Mechanism mechanismInstance) {
        if (mechanismInstance == null) {
            notFound()
            return
        }

        if (mechanismInstance.hasErrors()) {
            respond mechanismInstance.errors, view:'create'
            return
        }

        mechanismInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'mechanismInstance.label', default: 'Mechanism'), mechanismInstance.id])
                redirect mechanismInstance
            }
            '*' { respond mechanismInstance, [status: CREATED] }
        }
    }

    def edit(Mechanism mechanismInstance) {
        respond mechanismInstance
    }

    @Transactional
    def update(Mechanism mechanismInstance) {
        if (mechanismInstance == null) {
            notFound()
            return
        }

        if (mechanismInstance.hasErrors()) {
            respond mechanismInstance.errors, view:'edit'
            return
        }

        mechanismInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Mechanism.label', default: 'Mechanism'), mechanismInstance.id])
                redirect mechanismInstance
            }
            '*'{ respond mechanismInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Mechanism mechanismInstance) {

        if (mechanismInstance == null) {
            notFound()
            return
        }

        mechanismInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Mechanism.label', default: 'Mechanism'), mechanismInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'mechanismInstance.label', default: 'Mechanism'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
