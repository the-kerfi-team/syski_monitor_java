package uk.co.syski.client.JSON;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import uk.co.syski.client.System.CompleteSystemStatic;
import uk.co.syski.client.System.Components.Static.CPUStatic;
import uk.co.syski.client.System.Components.Static.SystemStatic;

public class JSONResponse
{
    //Get the JSON for whatever object is passed as a parameter to the functions.
    public static JsonObject getJSON(CompleteSystemStatic completeSystem)
    {
        return Json.object().add("action", "staticcompletesystem")
                .add("properties",
                    Json.object().add("cpu", getStaticCPUJSON(completeSystem.getCPU()))
                                 .add("system", getStaticSystemJSON(completeSystem.getSystem())));

    }

    public static JsonObject getJSON(CPUStatic cpu)
    {
        return Json.object().add("action", "staticcpu")
                .add("properties", getStaticCPUJSON(cpu));
    }

    private static JsonObject getStaticCPUJSON(CPUStatic cpu)
    {
        return Json.object().add("id", cpu.getID())
                .add("model", cpu.getModel())
                .add("manufacturer", cpu.getManufacturer())
                .add("architecture", cpu.getArchitecture())
                .add("clockspeed", cpu.getClock())
                .add("corecount", cpu.getCoreCount())
                .add("threadcount", cpu.getThreadCount());
    }

    public static JsonObject getJSON(SystemStatic system)
    {
        return Json.object().add("action", "staticsystem")
                .add("properties", getStaticSystemJSON(system));

    }

    private static JsonObject getStaticSystemJSON(SystemStatic system)
    {
        return Json.object().add("id", system.getID())
                .add("model", system.getModel())
                .add("manufacturer", system.getManufacturer())
                .add("type", system.getType())
                .add("hostname", system.getHostName());
    }
}
