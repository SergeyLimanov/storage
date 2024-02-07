import com.haulmont.cuba.core.global.AppBeans
import com.company.storage.service.PlaninScheduledService

postUpdate.add({

    try {
        def dm = AppBeans.get(PlaninScheduledService)
        dm.createScheduledTaskByPlanin()
    }
    catch (Exception ignore) {
    }
})
