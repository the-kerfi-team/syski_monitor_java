package uk.co.syski.client.JSON;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import uk.co.syski.client.System.CompleteSystemStatic;
import uk.co.syski.client.System.Components.Static.*;

public class JSONResponse
{
    //Get the JSON for whatever object is passed as a parameter to the functions.
    public static JsonObject getJSON(CompleteSystemStatic completeSystem)
    {
        return Json.object().add("action", "staticcompletesystem")
                .add("properties",
                    Json.object()
                        .add("cpu", getStaticCPUJSON(completeSystem.getCPU()))
                        .add("system", getStaticSystemJSON(completeSystem.getSystem()))
                        .add("os", getStaticOSJSON(completeSystem.getOS())))
                        .add("ram", getStaticRAMJSON(completeSystem.getRAM()))
                        .add("storage", getStaticStorageJSON(completeSystem.getStorage()))
                        .add("motherboard", getStaticMotherboardJSON(completeSystem.getMotherboard()))
                        .add("gpu", getStaticGPUJSON(completeSystem.getGPU()));

    }

    public static JsonObject getJSON(CPUStatic cpu)
    {
        return Json.object().add("action", "staticcpu")
                .add("properties", getStaticCPUJSON(cpu));
    }

    public static JsonObject getJSON(SystemStatic system)
    {
        return Json.object().add("action", "staticsystem")
                .add("properties", getStaticSystemJSON(system));

    }

    public static JsonObject getJSON(OSStatic os)
    {
        return Json.object().add("action", "staticos")
                .add("properties", getStaticOSJSON(os));
    }

    public static JsonObject getJSON(RAMStatic[] ram)
    {
        return Json.object().add("action", "staticram")
                .add("properties", Json.object().add("ram", getStaticRAMJSON(ram)));
    }

    public static JsonObject getJSON(StorageStatic[] storage)
    {
        return Json.object().add("action", "staticstorage")
                .add("properties", getStaticStorageJSON(storage));
    }

    public static JsonObject getJSON(MotherboardStatic mb)
    {
        return Json.object().add("action", "staticmotherboard")
                .add("properties", getStaticMotherboardJSON(mb));
    }

    public static JsonObject getJSON(GPUStatic gpu)
    {
        return Json.object().add("action", "staticgpu")
                .add("properties", getStaticGPUJSON(gpu));
    }

    private static JsonObject getStaticCPUJSON(CPUStatic cpu)
    {
        return Json.object()
                .add("id", cpu.getID())
                .add("model", cpu.getModel())
                .add("manufacturer", cpu.getManufacturer())
                .add("architecture", cpu.getArchitecture())
                .add("clockspeed", cpu.getClock())
                .add("corecount", cpu.getCoreCount())
                .add("threadcount", cpu.getThreadCount());
    }

    private static JsonObject getStaticSystemJSON(SystemStatic system)
    {
        return Json.object()
                .add("id", system.getID())
                .add("model", system.getModel())
                .add("manufacturer", system.getManufacturer())
                .add("type", system.getType())
                .add("hostname", system.getHostName());
    }

    private static JsonObject getStaticOSJSON(OSStatic os)
    {
        return Json.object()
                .add("name", os.getName())
                .add("version", os.getVersion())
                .add("architecture", os.getArchitecture());
    }

    private static JsonArray getStaticRAMJSON(RAMStatic[] ram)
    {
        JsonArray array = new JsonArray();
        for (RAMStatic r : ram)
            array.add(
                    Json.object()
                    .add("model", r.getModel())
                    .add("manufacturer", r.getManufacturer())
                    .add("type", r.getType())
                    .add("speed", r.getSpeed())
                    .add("size", r.getSize())
            );
        return array;
    }

    private static JsonArray getStaticStorageJSON(StorageStatic[] storage)
    {
        JsonArray array = new JsonArray();
        for (StorageStatic str : storage)
        {
            array.add(
                    Json.object()
                    .add("model", str.getModel())
                    .add("manufacturer", str.getManufacturer())
                    .add("type", str.getType())
                    .add("size", str.getSize())
            );
        }
        return array;
    }

    private static JsonObject getStaticMotherboardJSON(MotherboardStatic mb)
    {
        return Json.object()
                .add("model", mb.getModel())
                .add("manufacturer", mb.getManufacturer())
                .add("version", mb.getVersion());
    }

    private static JsonObject getStaticGPUJSON(GPUStatic gpu)
    {
        return Json.object()
                .add("model", gpu.getModel())
                .add("manufacturer", gpu.getManufacturer());
    }
}
